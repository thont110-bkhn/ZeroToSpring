package nguyentientho.sbjdbc_;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Objects;

public class BankAccountDAO extends JdbcDaoSupport {

    private static final String WHERE_ID = "WHERE ba.Id = ?";

    public List<BankAccountInfo> getBankAccounts() {
        String sql = BankAccountMapper.BASE_SQL;

        Object[] params = new Object[]{};
        BankAccountMapper mapper = new BankAccountMapper();
        List<BankAccountInfo> list = null;
        try {
            list = Objects.requireNonNull(this.getJdbcTemplate()).query(sql, params, mapper);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BankAccountInfo findBankAccount(long id) throws EmptyResultDataAccessException {
        String sql = BankAccountMapper.BASE_SQL + WHERE_ID;

        Object[] params = new Object[]{id};
        BankAccountMapper mapper = new BankAccountMapper();
        BankAccountInfo bankAccount = null;
        try {
            bankAccount = Objects.requireNonNull(this.getJdbcTemplate()).queryForObject(sql, params, mapper);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return bankAccount;
    }
}
