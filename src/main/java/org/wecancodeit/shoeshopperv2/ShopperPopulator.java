package org.wecancodeit.shoeshopperv2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.shoeshopperv2.models.Product;
import org.wecancodeit.shoeshopperv2.models.User;
import org.wecancodeit.shoeshopperv2.repositories.ProductRepository;
import org.wecancodeit.shoeshopperv2.repositories.UserRepository;

import javax.annotation.Resource;

@Component
public class ShopperPopulator implements CommandLineRunner {

	@Resource
	private UserRepository userRepo;

	@Resource
	private ProductRepository productRepo;

	@Override
	public void run(String... args) throws Exception {

		userRepo.save(new User("admin", "admin", "ADMIN"));
		userRepo.save(new User("user", "user", "USER"));

		Product nikeShoes = new Product("Nike",
				"Skate ipsum dolor sit amet, Kevin Harris impossible Santa Monica Beach half-flip risers pool. Opposite footed blunt mini ramp 1080 John Lucero betty. Bank late mute-air Lester Kasai boned out frontside. Japan air Dustin Dollin slap maxwell air frontside bank. Lipslide skate or die death box feeble 540. Casper hang up slap maxwell slam blunt. Masonite Tod Swank skater lip steps snake. Airwalk slam bluntslide crail grab Rector goofy footed. Bunson over the Junson rail finger flip pump full pipe rocket air. Skate key hang-up indy grab freestyle tail Blind. Cab flip Jeremy Wray roll-in shoveit nose grab vert. Wade Speyer pogo melancholy griptape manual ollie north.",
				"/images/nike.jpg");
		productRepo.save(nikeShoes);

		Product vansShoes = new Product("Vans",
				"Locals skate key masonite betty. Hugh Bod Boyle heel flip snake skate or die nosebone. Late fakie Steve Severin grind 270. Half-flip rip grip 1080 steps. Nose-bump lipslide transition sponsored. 360 half-flip frigid air transfer. Ollie hole nosebone nollie salad grind. Shinner roll-in drop in ollie north. Manual Kevin Jarvis bone air gap nollie. Rad Duel at Diablo face plant nose impossible. Quarter pipe risers Ray Underhill nose-bump lien air. Shoveit bone air Donger flail soul skate.",
				"/images/vans.jpg");
		productRepo.save(vansShoes);

		Product converseShoes = new Product("Converse",
				"No comply snake impossible yeah frigid air body varial. Downhill locals ollie Tracker airwalk boned out Arto Saari. Hard flip noseblunt slide airwalk nosegrind frontside 180. Rip grip Chris Haslam coper rad boned out nosebone hip. Face plant camel back sponsored Independent bruised heel Kevin Harris pump. Frigid air bank crail grab gnar bucket shoveit soul skate. Aerial crailtap fakie sick rail flypaper.",
				"/images/converse.jpg");
		productRepo.save(converseShoes);

		Product adidasShoes = new Product("Adidas",
				"Rock and roll crooked grind 1080 invert disaster feeble. Ollie hole rad dude downhill disaster casper slide. Lien air casper slide feeble sick hang ten rails. Grab rip grip regular footed tail pivot tuna-flip. Boneless fakie Jeremy Klein egg plant birdie hand rail nosepicker. Durometer sponsored frontside ho-ho noseblunt slide axle set.",
				"/images/adidas.jpg");
		productRepo.save(adidasShoes);

		Product reebokShoes = new Product("Reebok",
				"Fakie out regular footed skate key acid drop hang up. No comply boneless nose pop shove-it yeah. Randy Colvin half-flip lip boneless judo air slob air. Front foot impossible casper slide pogo Rodney Mullen invert no comply. Pump crail slide darkslide Tod Swank nose grab opposite footed. Rail slide birdie snake lip Dustin Dollin g-turn. Caballerial late dude darkslide skate key nosepicker. Gnar bucket snake Mike Carroll noseblunt slide 1080 hanger. Salad grind gap shoveit face plant kingpin. Bruised heel bluntslide ollie north 1080 Rector front foot impossible. Trucks The Wedge freestyle death box coffin concave.",
				"/images/reebok.png");
		productRepo.save(reebokShoes);

	}

}
