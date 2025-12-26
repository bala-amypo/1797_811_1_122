public interface InfluencerService {
    Influencer createInfluencer(Influencer influencer);
    List<Influencer> getAllInfluencers();
    Influencer getInfluencerById(Long id);
}
