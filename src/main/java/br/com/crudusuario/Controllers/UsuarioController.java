package br.com.crudusuario.Controllers;

import br.com.crudusuario.Exceptions.PayloadUsuarioSemInformacao;
import br.com.crudusuario.Exceptions.UsuarioNaoEncontrado;
import br.com.crudusuario.Modelos.Status;
import br.com.crudusuario.Modelos.TipoIngresso;
import br.com.crudusuario.Modelos.Usuario;
import br.com.crudusuario.Payloads.UsuarioPayload;
import br.com.crudusuario.Servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioServico usuarioServico;


    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> returnAllUsers() {
        return ResponseEntity.ok(usuarioServico.returnAllUsers());
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> returnUsuarioFromId(@PathVariable("id") Long id) throws UsuarioNaoEncontrado {
        return ResponseEntity.ok(usuarioServico.findById(id));
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> storeUser(@Valid @RequestBody UsuarioPayload payload) throws PayloadUsuarioSemInformacao {
        if (!validaPayloadUsuario(payload)) {
            Usuario usuario = new Usuario(payload.getNomeCompleto(), payload.getCpf(), payload.getNumeroCelular(), payload.getQuantiaPaga(), checkTipoIngresssoFromString(payload.getTipoIngresso()), checkStatusFromString(payload.getStatus()));
            usuarioServico.save(usuario);
            return ResponseEntity.ok(usuario);
        }
        throw new PayloadUsuarioSemInformacao("Usuário sem informação");
    }

    @PutMapping("/editar")
    public ResponseEntity<Usuario> editarUsuario(@Valid @RequestBody Usuario usuario) throws UsuarioNaoEncontrado {
        if (usuarioServico.validaSeIdExiste(usuario.getId())) {
            usuarioServico.save(usuario);
            return ResponseEntity.ok(usuario);
        }
        throw new UsuarioNaoEncontrado("Não existe nenhum usuário com este id - Erro ao editar o usuário");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        usuarioServico.deleteUserById(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

    private boolean validaPayloadUsuario(UsuarioPayload usuarioPayload) {
        return checkIfStringIsEmpty(usuarioPayload.getNomeCompleto()) || checkIfStringIsEmpty(usuarioPayload.getCpf()) ||
                checkIfStringIsEmpty(usuarioPayload.getNumeroCelular()) || checkIfStringIsEmpty(usuarioPayload.getTipoIngresso());
    }

    private boolean checkIfStringIsEmpty(String string) {
        return string.isEmpty();
    }

    private Status checkStatusFromString(String statusInString) {
        if (statusInString.equalsIgnoreCase("chegou") || statusInString.equalsIgnoreCase("presente") || statusInString.equalsIgnoreCase("esta aqui")) {
            return Status.CHEGOU;
        }
        return Status.NAO_CHEGOU;
    }

    private TipoIngresso checkTipoIngresssoFromString(String ingressoInString) {
        if (ingressoInString.equalsIgnoreCase("vip")) {
            return TipoIngresso.VIP;
        }
        return TipoIngresso.NORMAL;
    }
}
