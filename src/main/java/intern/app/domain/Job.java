package intern.app.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "numPeopleToHire", nullable = false)
    private int numPeopleToHire;

    @Column(name = "lastDate", nullable = false)
    private Date lastDate;

    @OneToMany(mappedBy="job")
    private Set<JobApplication> applications;

    public Job() {

    }

    public Job(String title, int numPeopleToHire) {
        this.title = title;
        this.numPeopleToHire = numPeopleToHire;
    }

    public long getId() {
        return id;
    }

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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(lastDate);
    }

    public void setLastDate(String lastDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.lastDate = formatter.parse(lastDate);
    }

    public Set<JobApplication> getApplications() {
        return applications;
    }

    public void setApplications(Set<JobApplication> applications) {
        this.applications = applications;
    }

    @Override
    public String toString() {
        return title;
    }
}
