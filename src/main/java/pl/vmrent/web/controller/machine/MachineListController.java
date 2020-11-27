package pl.vmrent.web.controller.machine;

import pl.vmrent.web.model.machine.Machine;
import pl.vmrent.web.model.machine.MachineGaming;
import pl.vmrent.web.model.machine.MachineWorkstation;
import pl.vmrent.web.service.MachineService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class MachineListController implements Serializable
{
    @Inject
    private MachineService machineService;

    private List<Machine> machines;

    @PostConstruct
    public void init()
    {
        machines = machineService.getAll();
    }

    public String deleteMachine(Machine machine)
    {
        machineService.deleteMachine(machine);
        return "show_vms.xhtml?faces-redirect=true";
    }

    public List<Machine> getMachines()
    {
        return machines;
    }
}
