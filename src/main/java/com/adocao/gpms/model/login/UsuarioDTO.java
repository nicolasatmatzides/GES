package com.adocao.gpms.model.login;

    import com.adocao.gpms.entity.Usuario;
    import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

    import javax.persistence.Column;
    import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDTO implements UserDetails {

    private String email;

    private String senha;

    private String confirmacaoSenha;

    private Boolean active;

    private String role;

    private String Name;

    private int Age;

    private String Gender;

    private String Address;

    private String CivilId;

    private String cpf;

    private List<GrantedAuthority> authorityList;

    public UsuarioDTO(Usuario user){
        this.email = user.getEmail();
        this.senha = user.getPassword();
        this.active = user.getActive();
        this.authorityList = Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public UsuarioDTO(){

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
