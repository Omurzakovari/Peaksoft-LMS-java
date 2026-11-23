package LMS.services.Impl;

import LMS.services.GroupService;
import LMS.user.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupServiceImpl  implements GroupService {
    private List<Group> groups = new ArrayList<>();

    @Override
    public void addGroup(Group group) {
        groups.add(group);
        System.out.println("Группа ийгиликтуу кошулду!");
    }

    @Override
    public Group getGroupByName(String name) {
        for (Group group : groups)
            if (group.getGroupName().equalsIgnoreCase(name)) {
                return group;
            }
        return null;
    }

    @Override
    public void updateGroupName(String oldName, String newName) {
        for (Group group : groups) {
            if (group.getGroupName().equalsIgnoreCase(oldName)) {
                group.setGroupName(newName);
                System.out.println("Группанын аты өзгөртүлдү!");
                return;
            }
        }
        System.out.println("Группа табылган жок!");
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public void deleteGroup(String name) {
        Group group = getGroupByName(name);
        if (group != null) {
            groups.remove(group);
            System.out.println("Группа ийгиликтүү өчүрүлдү!");
        } else {
            System.out.println("Группа табылган жок !" );
        }
    }
}