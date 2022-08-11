package org.acme.entity.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentHttpEntity {
    private Long id;

    private String name;

    private Long entrepriseId;
}
