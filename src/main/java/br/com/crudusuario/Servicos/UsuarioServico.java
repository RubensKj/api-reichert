package br.com.crudusuario.Servicos;

import br.com.crudusuario.Exceptions.UsuarioNaoEncontrado;
import br.com.crudusuario.Modelos.Usuario;
import br.com.crudusuario.Repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void save(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public void deleteUserById(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    public Usuario updateUser(Usuario usuario) {
        usuarioRepositorio.save(usuario);
        return usuario;
    }

    public Usuario findById(Long id) throws UsuarioNaoEncontrado {
        return usuarioRepositorio.findById(id).orElseThrow(() -> new UsuarioNaoEncontrado("Usuário com o id " + id + " não foi encontrado."));
    }

    public List<Usuario> returnAllUsers() {
        return usuarioRepositorio.findAll();
    }

    public boolean validaSeIdExiste(Long id) {
        return usuarioRepositorio.existsById(id);
    }
}
