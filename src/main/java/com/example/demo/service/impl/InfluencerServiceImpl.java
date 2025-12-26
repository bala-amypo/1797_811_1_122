@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Override
    public Influencer createInfluencer(Influencer influencer) {
        if (influencer.getSocialHandle() == null) {
            throw new IllegalArgumentException("Social handle required");
        }
        return influencer;
    }

    @Override
    public List<Influencer> getAllInfluencers() {
        return Collections.emptyList();
    }

    @Override
    public Influencer getInfluencerById(Long id) {
        throw new RuntimeException("Not found");
    }
}
