package com.thoughtworks.capability.gtb.entrancequiz.repository;


import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupsRepository {
    public static Integer GROUP_SIZE = 6;
    public static List<List<Group>> groupsHistory = new ArrayList<>();
}
