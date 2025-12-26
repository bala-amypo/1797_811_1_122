@Service
public class CampaignServiceImpl implements CampaignService {

    @Override
    public Campaign updateCampaign(Long id, Campaign campaign) {
        if (campaign.getEndDate() != null &&
            campaign.getStartDate() != null &&
            campaign.getEndDate().isBefore(campaign.getStartDate())) {
            throw new IllegalArgumentException("Invalid date range");
        }
        return campaign;
    }

    @Override
    public Campaign getCampaignById(Long id) {
        throw new RuntimeException("Not found");
    }

    @Override
    public List<Campaign> getAllCampaigns() {
        return Collections.emptyList();
    }
}
