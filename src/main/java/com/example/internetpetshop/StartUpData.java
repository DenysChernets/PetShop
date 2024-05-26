package com.example.internetpetshop;

import com.example.internetpetshop.Models.*;
import com.example.internetpetshop.Services.ProductService;
import com.example.internetpetshop.Services.UserService;
import com.example.internetpetshop.Repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.UUID;


@Component
public class StartUpData implements CommandLineRunner {
    private UserService userService;
    private ProductService productService;
    private CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartUpData.class);

    @Autowired
    public void StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        //adminAccount();
       // userAccount();
        //category();
        //exampleProducts();
    }

    private void userAccount() {
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender(Gender.FEMALE);
        user.setEmail("user@example.com");
        user.setStatus(Status.ACTIVE);
        user.setRole(UserRole.USER);
        userService.save(user);
    }

    private void adminAccount() {
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender(Gender.MALE);
        admin.setEmail("admin@example.com");
        admin.setRole(UserRole.ADMIN);
        admin.setStatus(Status.ACTIVE);
        userService.save(admin);
    }

    private void category() {
        Category category1 = new Category();
        Category category2 = new Category();
        Category category3 = new Category();
        Category category4 = new Category();
        category1.setId(UUID.randomUUID());
        category1.setCategoryName("Dogs");
        category1.setUrl("https://upload.wikimedia.org/wikipedia/commons/0/0c/About_The_Dog.jpg");
        category2.setId(UUID.randomUUID());
        category2.setCategoryName("Cats");
        category2.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz7qkv3rOFYnFxI37vW0hn2TK_vtK7z-vo7g&usqp=CAU");
        category3.setId(UUID.randomUUID());
        category3.setCategoryName("Rodents");
        category3.setUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTN_0LZcKYnKg8rPn3pXY3n8-l6HUP3dzJUVg&usqp=CAU");
        category4.setId(UUID.randomUUID());
        category4.setCategoryName("Parrots");
        category4.setUrl("data:image/jpeg;base64,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");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        categoryRepository.save(category4);
    }

    private void exampleProducts() {
        //final String NAME = "Example Name";
        //final String PICTURE_URL = "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX7389458.jpg";
        //final String DESCRIPTION = "Example Description";
        //final BigDecimal PRICE = BigDecimal.valueOf(50);
        final Category CATS = categoryRepository.findByCategoryName("Cats");
        final Category DOGS = categoryRepository.findByCategoryName("Dogs");
        final Category RODENTS = categoryRepository.findByCategoryName("Rodents");
        final Category PARROTS = categoryRepository.findByCategoryName("Parrots");
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();
        Product product9 = new Product();
        Product product10 = new Product();
        Product product11 = new Product();
        Product product12 = new Product();
        Product product13 = new Product();
        Product product14 = new Product();
        Product product15 = new Product();
        Product product16 = new Product();
        Product product17 = new Product();
        Product product18 = new Product();
        Product product19 = new Product();
        Product product20 = new Product();
        Product product21 = new Product();
        Product product22 = new Product();
        Product product23 = new Product();
        Product product24 = new Product();
        Product product25 = new Product();
        Product product26 = new Product();
        Product product27 = new Product();
        Product product28 = new Product();
        Product product29 = new Product();
        Product product30 = new Product();
        Product product31 = new Product();
        Product product32 = new Product();
        Product product33 = new Product();
        Product product34 = new Product();
        Product product35 = new Product();
        Product product36 = new Product();
        Product product37 = new Product();
        Product product38 = new Product();
        Product product39 = new Product();
        Product product40 = new Product();
        Product product41 = new Product();

        product1.setName("Dry food for long-haired cats Savory 8 kg (salmon)");
        product1.setPictureUrl("https://masterzoo.ua/content/images/8/400x400l85nn0/suxoy-korm-dlja-dlinnosherstnyx-koshek-savory-8-kg-losos-98861874755265.webp");
        product1.setDescription("Holistic food for long-haired cats.\n" +
                "\n Full-rational dry food for cats Savory will awaken in your pet the vital energy that he did not even know about yet.\n" +
                "\n The exclusive formula of the feed was developed by experienced European pet nutrition specialists. Using a holistic approach," +
                " we managed to create a biologically appropriate, healthy diet for cats that is healthy and delicious enough to lick your paws." +
                " The combination of selected natural ingredients makes it possible to take care of the health of the four-legged friend, " +
                "and the exquisite taste gives him the pleasure of daily consumption of Savory feed." +
                "Savory dry cat food contains fresh salmon meat and dehydrated white fish meat, berries, fruits and vegetables. " +
                "These components are created by nature to ensure the balanced functioning of the cat's body and give its coat an extraordinary appearance.\n" +
                "\n Savory feed - useful can be tasty!");
        product1.setCategory(CATS);
        product1.setPrice(BigDecimal.valueOf(150));
        product1.setQuantity(50);

        product2.setName("Wet food for sterilized cats Savory 100 g (lamb)");
        product2.setPictureUrl("https://masterzoo.ua/content/images/11/700x700l80mc0/vlazhnyy-korm-dlja-sterilizovannyx-koshek-savory-100-g-jagnenok-67235207553650.webp");
        product2.setDescription("Complete wet food with lamb for sterilized cats.\n" +
                "\n" +
                "The exclusive formulation of the feed was developed by experienced European pet nutrition specialists.\n" +
                "\n" +
                "Using a holistic approach, we managed to create a biologically appropriate, " +
                "healthy diet for cats that is healthy and delicious enough to lick your paws." +
                " The combination of selected natural ingredients makes it possible to take care of the health of the four-legged," +
                " and the exquisite taste gives him the pleasure of daily consumption of Savory feed.\n");
        product2.setCategory(CATS);
        product2.setPrice(BigDecimal.valueOf(2));
        product2.setQuantity(1000);

        product3.setName("Wet food for cats Savory 100 g (fish)");
        product3.setPictureUrl("https://masterzoo.ua/content/images/17/400x400l85nn0/vlazhnyy-korm-dlja-koshek-savory-100-g-ryba-11443792224402.webp");
        product3.setDescription("Complete wet food with fish for cats.\n" +
                "\n" +
                "The exclusive formulation of the feed was developed by experienced European pet nutrition specialists.\n" +
                "\n" +
                "Using a holistic approach, we managed to create a biologically appropriate," +
                " healthy diet for cats that is healthy and delicious enough to lick your paws. " +
                "The combination of selected natural ingredients makes it possible to take care of the health of the four-legged," +
                " and the exquisite taste gives him the pleasure of daily consumption of Savory feed.");
        product3.setCategory(CATS);
        product3.setPrice(BigDecimal.valueOf(2));
        product3.setQuantity(1000);

        product4.setName("Wet food for sterilized cats Savory 100 g (chicken)");
        product4.setPictureUrl("https://masterzoo.ua/content/images/14/400x400l85nn0/vlazhnyy-korm-dlja-sterilizovannyx-koshek-savory-100-g-kurica-33648586831783.webp");
        product4.setDescription("Complete wet food with chicken for sterilized cats.\n" +
                "\n" +
                "The exclusive formulation of the feed was developed by experienced European pet nutrition specialists.\n" +
                "\n" +
                "Using a holistic approach, we managed to create a biologically appropriate," +
                " healthy diet for cats that is healthy and delicious enough to lick your paws." +
                " The combination of selected natural ingredients makes it possible to take care of the health of the four-legged," +
                " and the exquisite taste gives him the pleasure of daily consumption of Savory feed.");
        product4.setCategory(CATS);
        product4.setPrice(BigDecimal.valueOf(2));
        product4.setQuantity(1000);

        product5.setName("Dry food for sterilized cats Optimeal Adult Cat Sterilized Turkey With Oat 1.5 kg (turkey and oats)");
        product5.setPictureUrl("https://masterzoo.ua/content/images/32/400x400l85nn0/sukhiy-korm-dlya-sterilizovanikh-kotiv-optimeal-adult-cat-sterilised-turkey-with-oat-15-kg-indichka-ta-oves-19670677223080.webp");
        product5.setDescription("Optimeal Adult Cat Sterilized Turkey With Oat Complete ration dry food for sterilized cats and neutered cats" +
                " - turkey and oats. Maintains the health of the urinary system thanks to the balanced content of minerals," +
                " maintains optimal weight thanks to L-carnitine, strengthens immunity.");
        product5.setCategory(CATS);
        product5.setPrice(BigDecimal.valueOf(20));
        product5.setQuantity(500);

        product6.setName("Dry food for sterilized cats Optimeal Adult Cat Sterilized Beef Sorghum 1.5 kg (beef and sorghum)");
        product6.setPictureUrl("https://masterzoo.ua/content/images/34/400x400l85nn0/sukhiy-korm-dlya-sterilizovanikh-kotiv-optimeal-adult-cat-sterilised-beef-sorghum-15-kg-yalovichina-ta-sorgo-56003248472727.webp");
        product6.setDescription("Optimeal Adult Cat Sterilized Beef & Sorghum Complete ration dry food for sterilized cats and neutered cats" +
                " - with a high content of beef and sorghum. Maintains the health of the urinary system thanks to the balanced content of minerals," +
                " maintains optimal weight thanks to L-carnitine and strengthens immunity.");
        product6.setCategory(CATS);
        product6.setPrice(BigDecimal.valueOf(20));
        product6.setQuantity(500);

        product7.setName("Dry food for adult cats Optimeal Adult Cat High in Veal 1.5 kg (veal)");
        product7.setPictureUrl("https://masterzoo.ua/content/images/36/400x400l85nn0/sukhiy-korm-dlya-doroslikh-kishok-optimeal-adult-cat-high-in-veal-15-kg-telyatina-18710538699859.webp");
        product7.setDescription("Optimeal Adult Cat High in Veal Complete ration dry food for adult cats with a high content of veal.\n" +
                "Fresh veal provides high palatability that satisfies even the pickiest cat, strengthens immunity and cleans teeth.");
        product7.setCategory(CATS);
        product7.setPrice(BigDecimal.valueOf(20));
        product7.setQuantity(500);

        product8.setName("Treats for cats Brit Care Functional Snack Dental 50 g (for teeth)");
        product8.setPictureUrl("https://masterzoo.ua/content/images/32/400x400l85nn0/43517427509915.webp");
        product8.setDescription("Functional, grain-free treats for healthy teeth and gums. Basil, thyme, rosemary, vitamin C." +
                " Semi-moist supplementary food for cats.");
        product8.setCategory(CATS);
        product8.setPrice(BigDecimal.valueOf(5));
        product8.setQuantity(1000);

        product9.setName("Treats for cats Brit Care Functional Snack Hairball 50 g (for hair removal)");
        product9.setPictureUrl("https://masterzoo.ua/content/images/33/400x400l85nn0/21881228601644.webp");
        product9.setDescription("To prevent the formation of wool lumps. Egg-shaped plantain, salmon oil, sea buckthorn," +
                " lignocellulose. Semi-moist supplementary food for cats.");
        product9.setCategory(CATS);
        product9.setPrice(BigDecimal.valueOf(5));
        product9.setQuantity(1000);

        product10.setName("Treats for cats Brit Care Functional Snack Shiny Hair 50 g (for skin and hair)");
        product10.setPictureUrl("https://masterzoo.ua/content/images/34/400x400l85nn0/35728106735683.webp");
        product10.setDescription("Functional, grain-free treats for a shiny coat and healthy skin. Calendula, salmon oil, sea buckthorn." +
                " Semi-moist supplementary food for cats.");
        product10.setCategory(CATS);
        product10.setPrice(BigDecimal.valueOf(5));
        product10.setQuantity(1000);

        product11.setName("SaniPet Cat Litter");
        product11.setPictureUrl("data:image/jpeg;base64,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");
        product11.setDescription("Hygienic odorless silica gel filler with unique\n" +
                "                    absorbent properties for use in cat litter boxes.\n" +
                "                    Quickly absorbs moisture, effectively retains\n" +
                "                    unpleasant odors and helps maintain hygiene in the\n" +
                "                    cat toilet.");
        product11.setCategory(categoryRepository.findByCategoryName("Cats"));
        product11.setPrice(BigDecimal.valueOf(10));
        product11.setQuantity(100);

        product12.setName("Dry food for adult dogs of large breeds (weighing from 25 to 45 kg) Brit Premium Adult L 3 kg (chicken)");
        product12.setPictureUrl("https://masterzoo.ua/content/images/47/400x400l85nn0/77170085742088.webp");
        product12.setDescription("Complete food with chicken for adult dogs of large breeds (25-45 kg). With a high content of chicken.");
        product12.setCategory(DOGS);
        product12.setPrice(BigDecimal.valueOf(25));
        product12.setQuantity(750);

        product13.setName("Dry food for puppies and young dogs of large breeds (weighing from 25 to 45 kg) Brit Premium Junior L 3 kg (chicken)");
        product13.setPictureUrl("https://masterzoo.ua/content/images/49/400x400l85nn0/49224567160535.webp");
        product13.setDescription("Complete food with chicken for puppies and young dogs (1-24 months) of large breeds (25-45 kg). With a high content of chicken.");
        product13.setCategory(DOGS);
        product13.setPrice(BigDecimal.valueOf(25));
        product13.setQuantity(750);

        product14.setName("Dry food for dogs with sensitive digestion Brit Premium Sensitive Lamb & Rice 15 kg (lamb)");
        product14.setPictureUrl("https://masterzoo.ua/content/images/24/400x400l85nn0/28856390437055.webp");
        product14.setDescription("Complete feed with wheat-free lamb for dogs of all breeds. Suitable for dogs with sensitive digestion. With a high content of lamb.");
        product14.setCategory(DOGS);
        product14.setPrice(BigDecimal.valueOf(90));
        product14.setQuantity(600);

        product15.setName("Wet food for dogs Brit Mono Protein Beef 400 g (beef)");
        product15.setPictureUrl("https://masterzoo.ua/content/images/25/400x400l85nn0/44056880143343.webp");
        product15.setDescription("Brit Mono Protein offers comprehensive and balanced nutrition. " +
                "A recipe containing one protein is recommended to reduce the risk of developing allergies and food intolerance." +
                " Complete food for dogs.");
        product15.setCategory(DOGS);
        product15.setPrice(BigDecimal.valueOf(5));
        product15.setQuantity(1200);

        product16.setName("Wet food for dogs Brit Mono Protein Tuna & Sweet Potato 400 g (tuna and sweet potato)");
        product16.setPictureUrl("https://masterzoo.ua/content/images/26/400x400l85nn0/90765990946620.webp");
        product16.setDescription("Brit Mono Protein offers comprehensive and balanced nutrition." +
                " A recipe containing one protein is recommended to reduce the risk of developing allergies and food intolerance." +
                " Complete food for dogs.");
        product16.setCategory(DOGS);
        product16.setPrice(BigDecimal.valueOf(5.5));
        product16.setQuantity(1200);

        product17.setName("Wet food for dogs with sensitive digestion Brit Premium By Nature Lamb with Buckwheat 800 g (lamb)");
        product17.setPictureUrl("https://masterzoo.ua/content/images/31/400x400l85nn0/40091057163050.webp");
        product17.setDescription("Meat pate with lamb for dogs with sensitive digestion.\n" +
                "\n" +
                "An ideal addition to pellets. Complex food, snack or improving the taste of pellets for adult dogs of all breeds.\n" +
                "\n" +
                "Helps to improve the diet and supplements with fluids. Contains collagen to support healthy joints, salmon oil, fruits and herbs.");
        product17.setCategory(DOGS);
        product17.setPrice(BigDecimal.valueOf(8));
        product17.setQuantity(1200);

        product18.setName("Treats for dogs Brit Functional Snack Immunity 150 g (for immunity)");
        product18.setPictureUrl("https://masterzoo.ua/content/images/36/400x400l85nn0/30828273906662.webp");
        product18.setDescription("Functional treats for dogs with insect and ginger to support immunity.");
        product18.setCategory(DOGS);
        product18.setPrice(BigDecimal.valueOf(5));
        product18.setQuantity(1000);

        product19.setName("Treats for dogs Brit Functional Snack Mobility 150 g (for joints)");
        product19.setPictureUrl("https://masterzoo.ua/content/images/37/400x400l85nn0/43726502028191.webp");
        product19.setDescription("Functional treats for dogs with squid and pineapple to support joints and cartilage.");
        product19.setCategory(DOGS);
        product19.setPrice(BigDecimal.valueOf(6));
        product19.setQuantity(1000);

        product20.setName("Treats for dogs Brit Functional Snack Endurance 150 g (for active)");
        product20.setPictureUrl("https://masterzoo.ua/content/images/6/400x400l85nn0/lakomstvo-dlya-sobak-brit-functional-snack-endurance-150-g-dlya-aktivnykh-14475199765107.webp");
        product20.setDescription("Functional treats for dogs with lamb and banana.");
        product20.setCategory(DOGS);
        product20.setPrice(BigDecimal.valueOf(6));
        product20.setQuantity(1000);

        product21.setName("Phytocomplex for dogs ProVET \"Fitovit\" 100 tablets, 112 g (for teeth and bones)");
        product21.setPictureUrl("https://masterzoo.ua/content/images/46/400x400l85nn0/fitokompleks-dlja-sobak-provet-fitovit-100-tabletok-112-g-dlja-zubov-i-kostey-37939110898574.webp");
        product21.setDescription("The feed supplement contains calcium, phosphorus and magnesium salts, which are easily absorbed by the body," +
                " which guarantees the further accumulation of minerals in bones and teeth. Phytocomplex of dry plant extracts and vitamin-mineral" +
                " complex ensure mineralization and proper formation of bones in puppies, strengthen the ossification process.");
        product21.setCategory(DOGS);
        product21.setPrice(BigDecimal.valueOf(5));
        product21.setQuantity(1000);

        product22.setName("Cunipic Alpha Pro feed for adult rabbits from 6 months.");
        product22.setPictureUrl("https://masterzoo.ua/content/images/37/700x700l80mc0/korm-dlja-vzroslyx-krolikov-ot-6-mesjacev-cunipic-alpha-pro-1750-g-80836556369665.webp");
        product22.setDescription("Alpha Pro Adult Rabbit Food is food for adult rabbits over 6 months of age." +
                " Its formulation is based on an all-in-one feeding system, where each pellet is extruded at a very low temperature," +
                " keeping all the nutrients in a homogeneous mixture. Therefore, your pet will stop choosing the pellets he likes the most," +
                " because they are all identical. Each pellet contains the necessary ingredients to keep your fluffy ear healthy, strong," +
                " satisfied and not suffering from nutrient deficiencies due to overeating.");
        product22.setCategory(RODENTS);
        product22.setPrice(BigDecimal.valueOf(40));
        product22.setQuantity(500);

        product23.setName("Food for chinchillas Vitakraft \"VITA Special\" 600 g");
        product23.setPictureUrl("https://masterzoo.ua/content/images/28/400x400l85nn0/72402433709940.webp");
        product23.setDescription("Complete food for chinchillas of different ages. " +
                "The menu in the form of pellets is ideal for picky animals. " +
                "The feed was developed by veterinarians together with leading experts" +
                " in the field of nutrition and contains all the nutrients necessary for a healthy and active life of the rodent." +
                " A large amount of fiber contributes to optimal digestion and longer chewing, contributing to the grinding of the rodent's teeth." +
                " The composition of Vitakraft VITA® Special includes the prebiotic inulin, which has a positive effect on the intestinal microflora.");
        product23.setCategory(RODENTS);
        product23.setPrice(BigDecimal.valueOf(25));
        product23.setQuantity(750);

        product24.setName("Hay for rodents Gimbi 500 g (rose and mint)");
        product24.setPictureUrl("https://masterzoo.ua/content/images/21/400x400l85nn0/seno-dlja-gryzunov-gimbi-500-g-roza-i-mjata-52303187041186.webp");
        product24.setDescription("Hay for rodents GRAIN FREE Gimbi with rose petals and fragrant mint 500 g.");
        product24.setCategory(RODENTS);
        product24.setPrice(BigDecimal.valueOf(10));
        product24.setQuantity(1000);

        product25.setName("Food for rats Priroda Cocktail \"Rat\" 500 g");
        product25.setPictureUrl("https://masterzoo.ua/content/images/12/400x400l85nn0/38948916813440.webp");
        product25.setDescription("The multicomponent grain mixture is supplemented with flattened grains," +
                " a special herbal and vegetable-grain granulate, which provides nutritional value and preserves" +
                " the active substances of natural components. The addition of dried herbs gives a mixture as close as possible" +
                " to the diet of rodents in natural conditions. The composition of \"Rat\" feed includes carob, dehydrated vegetables and fruits," +
                " which contain carotenoids to improve the pigmentation of the coat and the general health of the rodent.");
        product25.setCategory(RODENTS);
        product25.setPrice(BigDecimal.valueOf(8));
        product25.setQuantity(1200);

        product26.setName("Feed for rabbits Vitakraft \"LIFE Power\" 600 g");
        product26.setPictureUrl("https://masterzoo.ua/content/images/8/400x400l85nn0/89436275840596.webp");
        product26.setDescription("Food for rabbits with banana Life is a combination of a large number of tasty ingredients " +
                "that will certainly please your pet. Crispy carrots provide an additional amount of vital vitamins," +
                " a banana is a source of additional energy and minerals. The mixture also includes useful beta-glucans, " +
                "which strengthen the immune system, and crude fiber, which contributes to normal digestion and teeth grinding." +
                " The feed was developed with the participation of leading specialists in veterinary medicine.");
        product26.setCategory(RODENTS);
        product26.setPrice(BigDecimal.valueOf(10));
        product26.setQuantity(800);

        product27.setName("Feed for all types of rodents Priroda \"Granules\" 500 g");
        product27.setPictureUrl("https://masterzoo.ua/content/images/26/400x400l85nn0/korm-dlya-vsekh-vidov-gryzunov-priroda-granulyat-500-g-35222291322754.webp");
        product27.setDescription("Complete feed is intended for daily feeding of small and medium-sized rodents, as well as decorative rabbits.");
        product27.setCategory(RODENTS);
        product27.setPrice(BigDecimal.valueOf(4));
        product27.setQuantity(1000);

        product28.setName("Hay for rodents Priroda \"Meadow\" 300 g");
        product28.setPictureUrl("https://masterzoo.ua/content/images/13/400x400l85nn0/53572200288469.webp");
        product28.setDescription(" Excellent ecologically clean grass for hamsters, rabbits," +
                " guinea pigs and other rodents, which also serves as a good feed additive.");
        product28.setCategory(RODENTS);
        product28.setPrice(BigDecimal.valueOf(2));
        product28.setQuantity(2000);

        product29.setName("Feed for rabbits Vitakraft \"Emotion Beauty Selection\" 600 g (for skin and wool)");
        product29.setPictureUrl("https://masterzoo.ua/content/images/40/400x400l85nn0/47901370618998.webp");
        product29.setDescription("Crunchy carrots, tasty alfalfa, healthy flowers - Emotion Beauty Selection Adult " +
                "contains everything that is most delicious and useful for adult rabbits." +
                " The composition of the feed is specially selected for adult rabbits and contains methionine for hair growth. " +
                "Useful oils contribute to the shine of the coat and the health of the skin. Without added sugar, artificial colors and preservatives." +
                " A tasty and nutritious mixture in a package that preserves the aroma and freshness of the feed.");
        product29.setCategory(RODENTS);
        product29.setPrice(BigDecimal.valueOf(12));
        product29.setQuantity(800);

        product30.setName("Feed for rats Priroda Fiesta \"Rat\" 600 g");
        product30.setPictureUrl("https://masterzoo.ua/content/images/31/400x400l85nn0/korm-dlya-krys-priroda-fiesta-kryska-650-g-20772445715403.webp");
        product30.setDescription("Unlike other rodents, rats have a keen sense of smell," +
                " so eating food directly depends on its aroma and freshness. Good quality grain components," +
                " sunflower and pumpkin seeds, grain granulate, nuts," +
                " dried fruits and vegetables - this composition provides rats with excellent well-being, a beautiful appearance and a long life.");
        product30.setCategory(RODENTS);
        product30.setPrice(BigDecimal.valueOf(5));
        product30.setQuantity(1000);

        product31.setName("Food for chinchillas Vitakraft \"Pellets\" 1 kg");
        product31.setPictureUrl("https://masterzoo.ua/content/images/27/400x400l85nn0/98611127980542.webp");
        product31.setDescription("Vitakraft granulated food with a high malt content is ideal for the basic feeding of chinchillas." +
                " The specially developed recipe contains all the necessary substances, as well as a large amount of fiber for optimal digestion." +
                " Each granule is enriched with necessary vitamins. The feed is ideal for picky animals, which, in this case," +
                " do not have the opportunity to choose some of the ingredients.");
        product31.setCategory(RODENTS);
        product31.setPrice(BigDecimal.valueOf(7));
        product31.setQuantity(800);

        product32.setName("Food for medium parrots Special One 500 g");
        product32.setPictureUrl("https://masterzoo.ua/content/images/37/395x400l85nn0/korm-dlja-srednix-popugaev-special-one-500-g-45644051208585.webp");
        product32.setDescription("The feed recipe is designed specifically for medium-sized parrots kept at home. " +
                "It is compiled on the basis of the latest global feeding standards, as well as the recommendations of the world's leading specialists" +
                " in the breeding and maintenance of medium-sized parrots.");
        product32.setCategory(PARROTS);
        product32.setPrice(BigDecimal.valueOf(5));
        product32.setQuantity(850);

        product33.setName("Food for budgies Nature \"Parrot\" + Iodine and Echinacea 500 g");
        product33.setPictureUrl("https://masterzoo.ua/content/images/6/400x400l85nn0/67316273395842.webp");
        product33.setDescription("The feed recipe was developed based on the recommendations of leading specialists in breeding" +
                " and keeping decorative birds. The set of grain crops corresponds to the bird's diet in natural conditions. " +
                "Regular use of feed allows you to avoid vitamin deficiency, improper or prolonged molting, and provides birds with good condition." +
                " Iodine normalizes metabolism and helps to avoid disorders associated with being kept in a cage." +
                " Echinacea promotes the activation of metabolic processes, increasing the vitality of the bird.");
        product33.setCategory(PARROTS);
        product33.setPrice(BigDecimal.valueOf(3));
        product33.setQuantity(1000);

        product34.setName("Food for budgies Vitakraft \"Premium Menu\" 1 kg + 20%");
        product34.setPictureUrl("https://masterzoo.ua/content/images/41/400x400l85nn0/korm-dlja-volnistyx-popugaev-vitakraft-premium-menu-1-kg-20--15718249657718.webp");
        product34.setDescription("Vitakraft Menu for budgies is a balanced nutritional base that contains all the important nutrients" +
                " and mineral elements for the optimal condition of your bird. The Vital complex with iodine prevents vitamin and mineral " +
                "deficiency and ensures the parrot's longevity.");
        product34.setCategory(PARROTS);
        product34.setPrice(BigDecimal.valueOf(15));
        product34.setQuantity(600);

        product35.setName("Food for budgies Vitakraft \"Premium Menu\" 1 kg + 20%");
        product35.setPictureUrl("https://masterzoo.ua/content/images/27/700x700l80mc0/korm-dlja-krupnyx-popugaev-fiesta-afrika-600-g-74630735242297.webp");
        product35.setDescription("The feed recipe is designed specifically for large parrots that are kept at home." +
                " It is compiled in accordance with the recommendations of veterinarians and specialists in the breeding of ornamental birds." +
                " The feed contains all the necessary components that provide pets with vitamins, minerals and other useful substances. " +
                "Oats and pumpkin seeds enrich the diet of birds with iodine, zinc, essential amino acids, potassium, magnesium, iron, zinc," +
                " vitamins of group B. Dried apples, mountain ash, grapes and carob bring the composition of feed closer to the natural diet of birds," +
                " provide energy and normalize digestion. Thanks to hermetically sealed packaging," +
                " the feed retains a pleasant aroma and is protected from the harmful effects of moisture.");
        product35.setCategory(PARROTS);
        product35.setPrice(BigDecimal.valueOf(15));
        product35.setQuantity(600);

        product36.setName("Food for medium African parrots Vitakraft \"African\" 750 g");
        product36.setPictureUrl("https://masterzoo.ua/content/images/39/700x700l80mc0/69899021366986.webp");
        product36.setDescription("The composition of the feed corresponds to the bird's diet in its natural environment." +
                " Recommended for birds from Africa, so the food contains a mixture of ingredients such as fig, banana," +
                " coconut. In addition to the main ingredients, the feed contains vitamins and other nutrients that birds need for a healthy lifestyle.");
        product36.setCategory(PARROTS);
        product36.setPrice(BigDecimal.valueOf(18));
        product36.setQuantity(600);

        product37.setName("Food for budgies Priroda Cocktail \"Fruit\" 500 g");
        product37.setPictureUrl("https://masterzoo.ua/content/images/16/700x700l80mc0/32160745881272.webp");
        product37.setDescription("All the necessary grain components and goodies that are useful for your pet included in the feed mixture" +
                " - nuts and dried fruits, grass seeds - are useful for parrots during the nesting period; canary seeds, " +
                "safflower seeds and flax seeds contain trace elements necessary for brightly colored decorative birds; " +
                "the use of vitamins and minerals in the recipe allows the use of \"Fruit cocktail\" for young budgies," +
                " as well as for parrots in the molting period.");
        product37.setCategory(PARROTS);
        product37.setPrice(BigDecimal.valueOf(3.75));
        product37.setQuantity(800);

        product38.setName("Sand for birds Vitakraft \"Sandy Vogelsand\" 2.5 kg");
        product38.setPictureUrl("https://masterzoo.ua/content/images/49/700x700l80mc0/83753813956641.webp");
        product38.setDescription("Sand for birds Sandy 3-plus is an ideal hygienic filler for the bird cage. Natural quartz sand is an excellent tool for sharpening beaks and sand baths.");
        product38.setCategory(PARROTS);
        product38.setPrice(BigDecimal.valueOf(5));
        product38.setQuantity(750);

        product39.setName("Nature set for budgerigars 938 g (food + treats + mineral stone)");
        product39.setPictureUrl("https://masterzoo.ua/content/images/18/700x700l80mc0/nabor-priroda-dlya-volnistykh-popugaev-938-g-korm-lakomstva-mineralnyy-kamen-21874566680220.webp");
        product39.setDescription("The \"Nature\" set for budgerigars includes food \"Energy\" Parrot 500 g, \"Multivitamin\", \"Honey\", \"Fruit\"" +
                " ear treats and chalk with sea shells. The set is made in accordance with the recommendations of veterinarians - it is a complete menu" +
                " for a month.");
        product39.setCategory(PARROTS);
        product39.setPrice(BigDecimal.valueOf(4));
        product39.setQuantity(850);

        product40.setName("Treats for medium parrots Special One 90 g / 2 pcs (nut)");
        product40.setPictureUrl("https://masterzoo.ua/content/images/34/635x635l80mc0/lakomstvo-dlja-srednix-popugaev-special-one-90-g-2-sht-orex-98240429052491.webp");
        product40.setDescription("The treat recipe is designed specifically for decorative birds that are kept at home. It is based on the latest global feeding standards. Treats include products containing useful substances and minerals.");
        product40.setCategory(PARROTS);
        product40.setPrice(BigDecimal.valueOf(3.5));
        product40.setQuantity(1200);

        product41.setName("Mineral stone for budgies and medium-sized parrots Nature with citrus 18 g");
        product41.setPictureUrl("https://masterzoo.ua/content/images/17/700x700l80mc0/93043604030169.webp");
        product41.setDescription("Mineral supplements are necessary for both young and adult birds to maintain excellent condition," +
                " bright plumage, and the formation of strong bones. The mineral also acts as a gastrolith - a substance for better grinding " +
                "and grinding of grain in the muscular stomach. Another purpose of the mineral is to help pets clean and sharpen their beaks. " +
                "Dehydrated pieces of citrus supplement the diet with carbohydrates, vitamins and pectin substances," +
                " and also stimulate the consumption of minerals.");
        product41.setCategory(PARROTS);
        product41.setPrice(BigDecimal.valueOf(1));
        product41.setQuantity(1500);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);
        productService.save(product7);
        productService.save(product8);
        productService.save(product9);
        productService.save(product10);
        productService.save(product11);
        productService.save(product12);
        productService.save(product13);
        productService.save(product14);
        productService.save(product15);
        productService.save(product16);
        productService.save(product17);
        productService.save(product18);
        productService.save(product19);
        productService.save(product20);
        productService.save(product21);
        productService.save(product22);
        productService.save(product23);
        productService.save(product24);
        productService.save(product25);
        productService.save(product26);
        productService.save(product27);
        productService.save(product28);
        productService.save(product29);
        productService.save(product30);
        productService.save(product31);
        productService.save(product32);
        productService.save(product33);
        productService.save(product34);
        productService.save(product35);
        productService.save(product36);
        productService.save(product37);
        productService.save(product38);
        productService.save(product39);
        productService.save(product40);
        productService.save(product41);

    }

    public static void main(String[] args) {

    }
}
