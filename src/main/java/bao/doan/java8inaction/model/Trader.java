package bao.doan.java8inaction.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Trader {
   private String name;
   private String city;

    @Override
    public String toString() {
        return "Trader " + name + " in the " + city;
    }
}
