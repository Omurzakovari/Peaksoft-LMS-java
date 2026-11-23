package LMS.services;

import LMS.user.Group;

import java.util.List;

public interface GroupService {
    void addGroup ( Group group);
    Group getGroupByName (String name);
    void updateGroupName (String oldName, String newName);
    List<Group> getAllGroups ();
    void deleteGroup (String name);
}
