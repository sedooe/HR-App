package intern.app.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class JobCreateForm {
    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotNull
    @Min(1)
    private int numPeopleToHire;

    @NotEmpty
    private String lastDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumPeopleToHire() {
        return numPeopleToHire;
    }

    public void setNumPeopleToHire(int numPeopleToHire) {
        this.numPeopleToHire = numPeopleToHire;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    @Override
    public String toString() {
        return "JobCreateForm{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numPeopleToHire=" + numPeopleToHire +
                ", lastDate=" + lastDate +
                '}';
    }
}
