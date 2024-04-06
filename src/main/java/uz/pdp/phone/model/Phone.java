package uz.pdp.phone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Phone {
   private Integer id;
   private String model;
   private String macAddress;
   private Integer phoneNumber;

}
