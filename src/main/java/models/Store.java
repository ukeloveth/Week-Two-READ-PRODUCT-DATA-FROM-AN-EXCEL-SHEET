package models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Store {
    private List<Applicant> applicantList;
    private Product[] productList;

    public Store() {
        this.applicantList = new ArrayList<>();
        this.productList = new Product[12];
    }
}
