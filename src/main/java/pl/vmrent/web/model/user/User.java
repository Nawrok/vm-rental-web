package pl.vmrent.web.model.user;

import pl.vmrent.web.model.Entity;
import pl.vmrent.web.validator.unique.username.UniqueUsername;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@UniqueUsername
public class User extends Entity
{
    @Size(min = 3, max = 20)
    @NotBlank
    private String username;

    @Size(min = 8, max = 30)
    @NotBlank
    private String password;

    @NotBlank
    private String fullname;

    private boolean enabled;

    private Set<Role> roles;

    public User()
    {
        this.roles = new HashSet<>();
        this.roles.add(Role.Client);
    }

    public User(String username, String password, String fullname, boolean enabled, @NotEmpty Set<Role> roles)
    {
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }

    @JsonbTransient
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(@NotEmpty Set<Role> roles)
    {
        this.roles = roles;
    }

    @JsonbTransient
    public Set<String> getRolesAsString()
    {
        return roles.stream().map(Role::name).collect(Collectors.toSet());
    }
}
