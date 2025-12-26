@RestController
@RequestMapping("/influencers")
public class InfluencerController {

    private final InfluencerService service;

    public InfluencerController(InfluencerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Influencer> createInfluencer(@RequestBody Influencer i) {
        return ResponseEntity.ok(service.createInfluencer(i));
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        return ResponseEntity.ok(service.getAllInfluencers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencer(@PathVariable Long id) {
        return ResponseEntity.ok(service.getInfluencerById(id));
    }
}
