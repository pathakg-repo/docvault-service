package com.myexample.document.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Set<String> roles;

}
