@Service
public class SaleTransactionServiceImpl implements SaleTransactionService {

    @Override
    public SaleTransaction createSale(SaleTransaction tx) {
        if (tx.getTransactionAmount() == null ||
            tx.getTransactionAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Transaction amount must be > 0");
        }
        tx.setTransactionDate(new Timestamp(System.currentTimeMillis()));
        return tx;
    }

    public List<SaleTransaction> getSalesForCode(Long id) { return List.of(); }
    public List<SaleTransaction> getSalesForInfluencer(Long id) { return List.of(); }
    public List<SaleTransaction> getSalesForCampaign(Long id) { return List.of(); }
}
