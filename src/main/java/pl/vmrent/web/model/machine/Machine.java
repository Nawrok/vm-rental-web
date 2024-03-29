package pl.vmrent.web.model.machine;

import pl.vmrent.web.model.Entity;
import pl.vmrent.web.validator.unique.machinename.UniqueMachineName;

import javax.validation.constraints.*;

@UniqueMachineName
public abstract class Machine extends Entity
{
    @Size(min = 3, max = 20)
    @NotBlank
    private String name;

    @Min(1)
    @NotNull
    private Integer cores;

    @Min(1024)
    @Max(65536)
    @NotNull
    private Integer ramSize;

    @Min(128)
    @NotNull
    private Integer hddSize;

    public Machine()
    {
    }

    public Machine(String name, Integer cores, Integer ramSize, Integer hddSize)
    {
        this.name = name;
        this.cores = cores;
        this.ramSize = ramSize;
        this.hddSize = hddSize;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getCores()
    {
        return cores;
    }

    public void setCores(Integer cores)
    {
        this.cores = cores;
    }

    public Integer getRamSize()
    {
        return ramSize;
    }

    public void setRamSize(Integer ramSize)
    {
        this.ramSize = ramSize;
    }

    public Integer getHddSize()
    {
        return hddSize;
    }

    public void setHddSize(Integer hddSize)
    {
        this.hddSize = hddSize;
    }

    public String getType()
    {
        return this.getClass().getSimpleName();
    }
}
