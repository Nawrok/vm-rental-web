package pl.vmrent.web.controller.user;

import pl.vmrent.web.model.user.User;
import pl.vmrent.web.service.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UserEditController implements Serializable
{
    @Inject
    UserService userService;
    private User user;

    public String save()
    {
        return userService.updateUser(user) ? "" : null;
        //TODO BACK TO LIST PAGE
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}