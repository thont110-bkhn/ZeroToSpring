package nguyentientho.sbjdbc_;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankAccountInfo {
    private Long id;
    private String fullName;
    private double balance;

    public BankAccountInfo(Long id, String fullName, double balance) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
    }
}
