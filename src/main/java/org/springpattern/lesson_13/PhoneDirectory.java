package org.springpattern.lesson_13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneDirectory {
    private Map<String, List<String>> contacts;


    public PhoneDirectory() {
        contacts = new HashMap<>();
    }


    public void add(String surname, String phone) {
        contacts.putIfAbsent(surname, new ArrayList<>());
        contacts.get(surname).add(phone);
    }


    public List<String> get(String surname) {
        return contacts.getOrDefault(surname, new ArrayList<>());
    }


}
