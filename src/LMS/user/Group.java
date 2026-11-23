package LMS.user;

public class Group {
    private Long id;
    private String groupname;
    private String description;

    public Group(Long id, String groupname, String description) {
        this.id = id;
        this.groupname = groupname;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupname;
    }

    public void setGroupName(String groupname) {
        this.groupname = groupname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupname='" + groupname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

