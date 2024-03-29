package pl.vmrent.web.controller.rent;

import pl.vmrent.web.model.rent.Rent;
import pl.vmrent.web.model.user.Role;
import pl.vmrent.web.service.MachineService;
import pl.vmrent.web.service.RentService;
import pl.vmrent.web.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@Named
@ViewScoped
public class RentController implements Serializable
{
    @Inject
    private RentService rentService;

    @Inject
    private MachineService machineService;

    @Inject
    private UserService userService;

    private Rent rent = new Rent();

    private UUID machineId;

    @PostConstruct
    private void init()
    {
        rent.setUser(userService.getCurrentUser());
    }

    public String initRent()
    {
        rentService.findRentById(rent.getId()).ifPresent(this::setRent);
        return rentService.existsRent(rent) &&
                (userService.getCurrentRole() == Role.Owner ||
                        rent.getUser().equals(userService.getCurrentUser())) ? null : "error";
    }

    public String initRentMachine()
    {
        machineService.findMachineById(machineId).ifPresent(m -> rent.setMachine(m));
        return machineService.existsMachine(rent.getMachine()) ? null : "error";
    }

    public String submit()
    {
        Optional<Rent> optionalRent = Optional.ofNullable(rentService.saveRent(rent));
        return optionalRent.map(r -> "show-rents.xhtml?faces-redirect=true").orElse(null);
    }

    public Rent getRent()
    {
        return rent;
    }

    public void setRent(Rent rent)
    {
        this.rent = rent;
    }

    public UUID getMachineId()
    {
        return machineId;
    }

    public void setMachineId(UUID machineId)
    {
        this.machineId = machineId;
    }
}
