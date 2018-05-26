package com.mycompany.personaltech.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-26T14:54:08")
@StaticMetamodel(MedStatus.class)
public class MedStatus_ { 

    public static volatile SingularAttribute<MedStatus, Boolean> probOsseo;
    public static volatile SingularAttribute<MedStatus, String> obsprobOsseo;
    public static volatile SingularAttribute<MedStatus, String> probPressaoAterial;
    public static volatile SingularAttribute<MedStatus, String> obsProbPressaoAterial;
    public static volatile SingularAttribute<MedStatus, Boolean> probCardiaco;
    public static volatile SingularAttribute<MedStatus, Long> id;
    public static volatile SingularAttribute<MedStatus, String> obsProbCardiaco;
    public static volatile SingularAttribute<MedStatus, String> diabetes;

}