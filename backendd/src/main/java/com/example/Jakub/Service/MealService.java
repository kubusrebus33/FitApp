package com.example.Jakub.Service;

import com.example.Jakub.Dto.UserProfileDto;
import com.example.Jakub.Entity.*;
import com.example.Jakub.Exception.AppException;
import com.example.Jakub.Repository.*;
import com.example.Jakub.Entity.*;
import com.example.Jakub.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MealService {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private com.example.Jakub.Repository.mealKitRepository mealKitRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MealIngredientRepository mealIngredientRepository;

    @Autowired
    private UserService userService;

    public void seedMeals() {
        mealRepository.save(new Meal("Makaron z pesto, pieczarkami i kurczakiem", 675.0f, 40.9f, 61.7f, 29.8f, "Makaron ugotuj al'dente (zostaw około 40 ml wody z gotowania). Mięso pokrój w kostkę, cebulę i czosnek posiekaj, pieczarki pokrój w plasterki. Cebulę i czosnek zeszklij na patelni. Następnie dodaj pieczarki i duś pod przykryciem aż puszczą wodę. Dodaj mięso i smaż aż będzie gotowe. Przypraw do smaku. Dodaj pesto i wodę. Na koniec dodaj śmietanę, makaron i wymieszaj. Danie posyp parmezanem i udekoruj rukolą.", 1, 1, 1, "dinner"));
        mealRepository.save(new Meal("Kurczak teriyaki z kaszą i brokułem", 823.0f, 64.1f, 85.5f, 27.3f, "Kaszę ugotuj. Brokuł podziel na mniejsze różyczki, marchewkę pokrój w drobną kostkę. Na patelni podsmaż warzywa, dodaj sos sojowy i trochę wody. Duś do miękkości. Dodaj kaszę i całość wymieszaj. Mięso pokrój w plastry, przypraw do smaku pieprzem i solą i podsmaż z obu stron. Wlej sos teriyaki, dodaj sezam i smaż jeszcze 1 minutę. Kaszę podawaj z mięsem.", 1, 1, 0, "dinner"));
        mealRepository.save(new Meal("Makaron wysokobiałkowy z kurczakiem", 922.0f, 64.9f, 86.0f, 35.4f, "Makaron ugotuj al'dente. Mięso pokrój w kostkę. Cebulę posiekaj i zeszklij na patelni. Dodaj koncentrat, przyprawy i wymieszaj. Dodaj mięso i smaż aż będzie gotowe. Wlej śmietankę, dodaj starty ser i wymieszaj. Na koniec dodaj makaron i połącz wszystkie składniki. Na talerzu posyp posiekaną natką.", 1, 1, 1, "dinner"));
        mealRepository.save(new Meal("Stek wołowy z kaszą i brokułami", 806.0f, 64.9f, 97.8f, 21.4f, "Kaszę i brokuł ugotuj. Na patelni rozgrzej oliwę i połóż mięso. Obsmażaj po 1 minucie z każdej strony aż mięso będzie brązowe. Zmniejsz ogień, mięso przypraw do smaku pieprzem i solą i smaż z obu stron aż steki będą średnio wysmażone. Przygotuj sos: jogurt wymieszaj z posiekanym czosnkiem i koperkiem. Kaszę podawaj z mięsem i brokułami. Brokuły polej sosem.", 1, 0, 1, "dinner"));
        mealRepository.save(new Meal("Pieczony halibut z ryżem i brokułem", 374.0f, 28.5f, 50.1f, 8.0f, "Piekarnik nagrzej do 180 stopni. Ryż i brokuł ugotuj. Brokuł podziel na mniejsze różyczki. Rybę skrop oliwą z oliwek, sokiem z cytryny, przypraw do smaku oregano, pieprzem i solą. Rybę ułóż na blaszce wyłożonej papierem do pieczenia i piecz przez 15 minut. Rybę posyp posiekanym koperkiem i podawaj z ryżem i brokułami.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Kaszotto gryczane z kurkami", 457.0f, 33.4f, 53.9f, 14.0f, "Kaszę ugotuj według instrukcji na opakowaniu i wymieszaj z sosem sojowym. Mięso pokrój w kostkę, czosnek posiekaj i podsmaż na patelni. Przypraw do smaku. Cebulę i pora pokrój w półplasterki i wrzuć na patelnię. Smaż około 5-6 minut i przypraw pieprzem i solą. Na koniec dodaj umyte i oczyszczone kurki i smaż kilka minut. Wsyp ugotowaną kaszę i wymieszaj z zawartością patelni. Na talerzu posyp posiekanym szczypiorkiem.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy", 604.0f, 30.7f, 69.3f, 24.3f, "Makaron ugotuj al'dente. Cebulę posiekaj, kurczaka pokrój w kostkę. Na patelni zeszklij cebulę, następnie dodaj mięso. Przypraw do smaku. Gdy mięso będzie gotowe dodaj oczyszczone kurki i smaż kilka minut. Wlej śmietanę (w temperaturze pokojowej) i wymieszaj. Dodaj makaron i połącz wszystkie składniki. Posyp posiekaną natką.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Risotto dyniowe z kurczakiem", 652.0f, 43.6f, 70.1f, 23.3f, "Mięso i dynię pokrój w kostkę. W garnku zagotuj bulion i podgrzej mleko. Cebulę posiekaj i podsmaż na niewielkim ogniu na maśle. Następnie dodaj mięso i obsmażaj z obu stron. Dodaj dynię i smaż około 2 minuty. Wsyp ryż, wymieszaj i całość zalej bulionem (możesz to robić stopniowo). Dodaj przyprawy. Na koniec dodaj starty ser, śmietanę i wymieszaj.", 1, 0, 1, "dinner"));
        mealRepository.save(new Meal("Makaron z tofu i pomidorami", 493.0f, 22.2f, 70.7f, 17.3f, "Makaron ugotuj al dente wg instrukcji na opakowaniu. Tofu pokrój w małą kostkę. Pomidory suszone pokrój w drobne paseczki, natomiast pomidory koktajlowe przerój na pół. Na rozgrzaną patelnię wlej oliwę, dodaj tofu, pomidory i przyprawy. Duś pod przykryciem ok. 7 minut. Świeże zioła posiekaj. Makaron podawaj z zawartością patelni posypane ziołami.", 0, 1, 0, "dinner"));
        mealRepository.save(new Meal("Indyk z brokułem w sosie sojowym", 448.0f, 30.4f, 9.6f, 32.4f, "Na patelni rozgrzej olej kokosowy. Dodaj mięso. Smaż, aż straci swój różowy kolor. Pokrój brokuł na małe kawałki. Imbir zetrzyj lub drobno posiekaj. Świeże zioła posiekaj. Dodaj wszystkie składniki do mięsa i duś pod przykryciem ok. 15-20 minut, aż brokuł będzie mięki.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Ryż z warzywami i jajkiem sadzonym", 563.0f, 21.6f, 49.8f, 30.9f, "Ryż ugotuj. Warzywa pokrój w drobną kostkę i podsmaż na patelni. Gdy warzywa będą miękkie, dodaj ryż, przyprawy i całość wymieszaj. Usmaż sadzone jajka i podawaj z warzywnym ryżem. Posyp posiekaną natką i pestkami dyni.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Curry z tofu w mleczku kokosowym z ryżem", 533.0f, 16.2f, 59.5f, 28.2f, "Ryż i fasolkę ugotuj. Tofu pokrój w kostkę i przypraw do smaku. Podsmaż na patelni. Paprykę i marchewkę pokrój w drobną kostkę i wrzuć na patelnię. Dodaj sos sojowy i krótko podsmażaj aż warzywa zmiękną. Możesz dolać trochę wody. Na koniec wlej mleczko kokosowe, dodaj ugotowaną fasolę, wymieszaj i zagotuj. Curry podawaj z ryżem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną", 611.0f, 22.8f, 92.6f, 19.2f, "Piekarnik nagrzej do temperatury 180 stopni. Soczewicę oraz kaszę jaglaną ugotuj wg instrukcji na opakowaniu. Świeże zioła posiekaj. Kaszę, soczewicę, mąkę, zioła oraz przyprawy zblenduj. Formuj z masy małe kulki, układaj na blaszce do pieczenia wyłożonej papierem, a następnie spłaszcz do formy kotleta. Piecz ok 15 minut lub do zarumienienia. Kapustę połącz z olejem. Kotlety podawaj z kapustą kiszoną.", 0, 1, 0, "dinner"));
        mealRepository.save(new Meal("Łosoś pieczony z warzywami i chrupkami z ciecierzycy", 720.0f, 48.0f, 23.5f, 49.5f, "Piekarnik nagrzej do 190 stopni. Łososia i ciecierzycę skrop oliwą, przypraw do smaku pieprzem, słodką papryką i solą. Rybę i ciecierzycę połóż na papierze do pieczenia i piecz przez 15 minut. Przygotuj sałatkę: ogórka pokrój w plasterki, pomidorki przekrój na pół, sałatę porwij. Wymieszaj wszystkie składnik i skrop olejem lnianym. Przypraw do smaku i posyp ciecierzycą. Rybę podawaj z sałatką.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Sałatka z soczewicy z halloumi", 996.0f, 46.1f, 57.5f, 64.0f, "Grzyby i ser pokrój. Na patelni rozgrzej olej, dodaj grzyby i podsmażaj, aż się zarumienią. Następnie dodaj ser i chilli. Pozostałe warzywa pokrój. Soczewicę odcedź. Wszystkie składniki połącz w misce wraz z przyprawami oraz oliwą.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Gulasz z soczewicy z ziemniakami i groszkiem", 705.0f, 50.8f, 71.0f, 23.8f, "Warzywa obierz i pokrój w kostkę. Zioła posiekaj i zostaw na koniec do posypania gotowego dania. Mięso pokrój w kostkę. Do garnka wlej oliwę, dodaj mięso i lekko podsmaż. Dodaj pozostałe składniki. Duś pod przykryciem przez 20 min na średniej mocy palnika. Wyłożone na talerz danie posyp ziołami.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Sałatka z burakiem, komosą ryżową i pestkami dyni", 681.0f, 20.3f, 73.6f, 34.9f, "Komosę ugotuj wg instrukcji na opakowaniu, wyłóż na talerz aby wystygła. Warzywa pokrój. Wymieszaj wszystkie składniki z olejem i pestkami.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Zupa koperkowa z klopsikami", 474.0f, 36.3f, 46.9f, 16.5f, "Mięso włóż do miski, dodaj mąkę, posiekaną pietruszkę, sól i pieprz. Wymieszaj, uformuj małe kulki i obtocz je delikatnie w mące. Do garnka wrzuć pokrojonego w kostkę ziemniaka, pietruszkę i marchewkę. Zalej warzywa gorącym bulionem i gotuj ok. 10 minut. Dodaj klopsiki, masło klarowane i gotuj kolejne 15 minut. Dodaj posiekany koperek, podgotowuj jeszcze chwilę. Dopraw do smaku solą i pieprzem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Zapiekany makaron bezglutenowy", 829.0f, 42.4f, 76.9f, 39.1f, "Piekarnik nagrzej do temperatury 180 stopni. Na patelni usmaż mięso na maśle klarowanym, dodając do niego pod koniec pieprz, sól i bazylię. Do mięsa dodaj przecier pomidorowy i wodę; wymieszaj i duś na małym ogniu, do odparowania płynu. Dopraw do smaku solą, pieprzem, bazylią i wymieszaj. Przygotuj sos beszamelowy: w garnku rozgrzej masło, dodaj mąki i smaż przez 2 minuty cały czas mieszając. Wlej napój roślinny i mieszaj aby nie powstały grudki. Dopraw do smaku solą i gałką muszkatołową. Na koniec dodaj płatki drożdżowe i wymieszaj. Naczynie żaroodporne wysmaruj tłuszczem, dodaj porcję sosu beszamelowego, połowę makaronu, sos boloński, pozostały makaron i sos beszamelowy. Piecz około 45 minut.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Makaron gryczany z sosem pomidorowym i bazylią", 384.0f, 7.9f, 66.4f, 11.1f, "Makaron ugotuj wg instrukcji na opakowaniu Pozostałe składniki umieść w garnku, zagotuj. Makaron podawaj z sosem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Ryba pieczona z frytkami z batatów i surówką", 559.0f, 32.2f, 67.8f, 20.1f, "Piekarnik nagrzej do 190 stopni. Batata pokrój w cienkie paski. Blaszkę wyłóż papierem do pieczenia dodaj frytki i rybę, skrop oliwą z oliwek i przypraw do smaku. Piecz około 20 minut. Przygotuj surówkę: kapustę posiekaj, jabłko i marchew zetrzyj, wymieszaj, skrop oliwą i sokiem z cytryny. Rybę podawaj z frytkami i surówką.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Tortilla kukurydziana z mozzarellą, hummusem i warzywami", 412.0f, 20.7f, 54.9f, 13.2f, "Warzywa pokrój w kostkę. Tortillę posmaruj hummusem. Na tortillę nałóż wszystkie składniki, posyp startą mozzarellą i zwiń.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Bezglutenowy wege wrap", 497.0f, 24.1f, 61.0f, 19.7f, "Placki: Wymieszaj mąkę z ziołami, gorącą wodą, oliwą, szczypiorkiem i zagnieć ciasto. Rozwałkuj na placek i smaż na rumiano na suchej patelni. Warzywa pokrój, zioła posiekaj. Na usmażone placki układaj dodatki - warzywa i tofu. Polej sosem: jogurt + przyprawy + musztarda. Wrapa zawiń.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Kawowy shake proteinowy", 717.0f, 1.0f, 97.1f, 19.4f, "Kawę zaparz i ostudź. Wszystkie składniki zblenduj na koktajl.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Grzanki z burratą i pomidorkami", 473.0f, 14.7f, 47.6f, 26.7f, "Bułkę przekrój na pół i podgrzej na suchej patelni. Pomidorki pokrój na mniejsze kawałki i podsmaż na patelni. Przypraw do smaku. Na grzanki nałóż pomidorki, plasterki burraty i udekoruj bazylią.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Owsianka ze śliwkami, czekoladą i odżywką", 857.0f, 1.0f, 110.6f, 25.9f, "Płatki wsyp do garnka i zalej mlekiem. Gotuj do miękkości. W międzyczasie wrzuć połamaną czekoladę i mieszaj aż się rozpuści. Owsiankę przełóż do miski i odstaw na 5 minut, aby lekko ostygła. Dodaj odżywkę i wymieszaj. Owsiankę podawaj z dodatkami.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Wysokokaloryczny shake owocowy z malinami", 871.0f, 46.8f, 120.6f, 25.1f, "Banany obierz. Wszystkie składniki zblenduj na gładki koktajl.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowe placki białkowe ze skyrem", 709.0f, 47.2f, 65.2f, 29.0f, "Białka oddziel od żółtek i ubij na sztywną pianę. W misce wymieszaj żółtka, serek grani, mąkę, proszek do pieczenia i erytrytol. Dodaj białka i całość dokładnie wymieszaj. Na rozgrzaną patelnię nakładaj łyżką placuszki i smaż z obu stron pod przykryciem. Podawaj ze skyrem.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Owsianka z odżywką białkową i owocem", 406.0f, 22.6f, 47.7f, 15.0f, "Płatki owsiane zalej wrzątkiem i odstaw na 5 minut, aby napęczniały. Dodaj odżywkę białkową, mleko i całość wymieszaj. Dodaj pokrojone owoce i orzechy.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Jajecznica z kurkami z pieczywem bezglutenowym", 502.0f, 18.8f, 43.2f, 29.2f, "Cebulę posiekaj i zeszklij na patelni. Dodaj posiekane pomidory i oczyszczone i umyte kurki. Smaż aż kurki zmiękną i odparuje woda. Wbij jajka i smaż do uzyskania odpowiedniej konsystencji. Jajecznicę podawaj na pieczywie.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Jajecznica z kurkami na grahamce", 529.0f, 23.6f, 54.5f, 26.9f, "Cebulę posiekaj i zeszklij na patelni. Dodaj posiekane pomidory i oczyszczone i umyte kurki. Smaż aż kurki zmiękną i odparuje woda. Wbij jajka i smaż do uzyskania odpowiedniej konsystencji. Jajecznicę podawaj na bułce.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Szakszuka z kurkami", 345.0f, 18.7f, 21.9f, 22.0f, "Cebulę i czosnek posiekaj, pomidory sparz, obierz ze skórki i pokrój w kostkę. Na patelni zeszklij cebulę z czosnkiem, następnie dodaj kurki. Smaż kilka minut i przypraw do smaku. Dodaj pomidory, wymieszaj i smaż bez mieszania około 5 minut, aż odparuj woda. Wbij jajka i smaż pod przykryciem aż białko się zetnie, a żółtko będzie płynne. Na talerzu posyp posiekaną natką.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Wysokobiałkowy omlet owsiany", 1104.0f, 42.7f, 167.3f, 33.0f, "Wszystkie składniki zblenduj na gładką masę. Na rozgrzaną patelnię wlej masę i smaż pod przykryciem z obu stron.", 0, 1, 1, "dinner"));
        mealRepository.save(new Meal("Owsianka bezglutenowa z serkiem wiejskim i owocami", 548.0f, 28.1f, 76.5f, 16.0f, "Do garnka wlej mleko, wsyp płatki, dodaj połówkę pokrojonego w plasterki banana i zagotuj. Owsiankę przełóż do miski, dodaj serek wiejski, owoce i posyp orzechami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Kanapki z hummusem dyniowym i grillowanym tofu", 438.0f, 15.3f, 67.8f, 13.7f, "Do miski wrzuć puree z dyni, ciecierzycę, tahini, dodaj sok z cytryny i przyprawy. Całość zlenduj na gładką masę. W razie potrzeby dolej trochę wody, aby powstała gładka konsystencja. Tofu pokrój w plasterki i zgrilluj z obu stron. Z podanych składników przygotuj kanapki.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowe gofry dyniowe ze skyrem i owocami", 482.0f, 42.5f, 50.2f, 13.7f, "Do miski wbij jajko, dodaj puree dyniowe, mąkę, odżywkę białkową, cynamon i całość zblenduj na gładką masę. Gofry piecz w nagrzanej i wysmarowanej olejem gofrownicy. Podawaj ze skyrem i owocami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Placuszki dyniowe z bananem i tahini", 611.0f, 36.0f, 91.2f, 15.3f, "Banana rozgnieć widelcem na puree. W misce wymieszaj banana, puree z dyni, jajko, mąkę, proszek do pieczenia i cynamon. Posłodź do smaku. Na rozgrzaną patelnię nakładaj łyżką placuszki i smaż z obu stron. Podawaj z dodatkami.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Jaglanka z brzoskiwnią", 353.0f, 11.7f, 68.0f, 4.7f, "Kaszę ugotuj wg instrukcji na opakowaniu. Owoce pokrój. Jogurt wymieszaj z siemieniem lnianym. Połącz wszystkie składniki.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Musli z winogronem i jogurtem kokosowym", 293.0f, 9.3f, 51.7f, 6.5f, "Wymieszaj wszystkie składniki.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Bananowe musli z orzechami włoskimi z jogurtem bez laktozy", 432.0f, 13.7f, 58.5f, 17.3f, "Wszystkie składniki wymieszaj.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Granola z bananowym jogurtem bez laktozy", 502.0f, 13.1f, 69.1f, 21.9f, "Banana zblenduj z jogurtem naturalnym na gładką masę. Na patelni upraż płatki owsiane, otręby i płatki migdałów. Na koniec prażenia dodaj olej kokosowy, miód i smaż jeszcze około 1 minuty. Dzięki temu granola będzie chrupiąca i aromatyczna. Do miski przełóż jogurt, dodaj granolę i owoce.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Granola z bananem i jogurtem kokosowym", 582.0f, 10.2f, 77.2f, 24.2f, "Banana zblenduj z jogurtem kokosowym na gładką masę. Na patelni upraż płatki owsiane, otręby i płatki migdałów. Na koniec prażenia dodaj olej kokosowy, miód i smaż jeszcze około 1 minuty. Dzięki temu granola będzie chrupiąca i aromatyczna. Do miski przełóż jogurt, dodaj granolę i owoce.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Kakaowa granola z pestkami dyni i jogurtem bez laktozy", 523.0f, 15.0f, 60.8f, 25.3f, "Płatki owsiane i nasiona dyni upraż na suchej patelni, dodaj miód, kakao, masło i dokładnie wymieszaj. Podawaj z jogurtem.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Kakaowa granola z pestkami dyni i jogurtem kokosowym", 542.0f, 8.4f, 64.2f, 24.4f, "Płatki owsiane i nasiona dyni upraż na suchej patelni, dodaj miód, kakao, olej kokosowy i dokładnie wymieszaj. Podawaj z jogurtem.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Omlet sernikowy bez laktozy z brzoskwinią", 626.0f, 39.4f, 53.4f, 29.0f, "Brzoskwinię pokrój w kostkę. Pozostałe składniki zblenduj na gładką masę. Dodaj brzoskwinię i wymieszaj łyżką. Na rozgrzaną patelnię wlej masę i smaż z obu stron pod przykryciem.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Omlet sernikowy z brzoskwinią", 621.0f, 47.6f, 56.4f, 23.4f, "Brzoskwinię pokrój w kostkę. Pozostałe składniki zblenduj na gładką masę. Dodaj brzoskwinię i wymieszaj łyżką. Na rozgrzaną patelnię wlej masę i smaż z obu stron pod przykryciem.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Burger śniadaniowy bez laktozy z jajkiem sadzonym", 377.0f, 15.1f, 43.9f, 16.8f, "Bułkę przekrój na pół i podgrzej na suchej patelni. Usmaż sadzone jajko. Z podanych składników przygotuj burgera. Bułkę złóż na pół.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Burger śniadaniowy z jajkiem sadzonym", 406.0f, 16.0f, 48.3f, 18.0f, "Bułkę przekrój na pół i podgrzej na suchej patelni. Usmaż sadzone jajko. Z podanych składników przygotuj burgera. Bułkę złóż na pół.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Omlet szpinakowy z białek", 365.0f, 34.1f, 32.7f, 11.2f, "Białka ubij na sztywną pianę z dodatkiem soli. Szpinak zblenduj z mlekiem i wymieszaj z białkami. Dodaj mąkę, proszek, przyprawy i delikatnie wymieszaj. Na rozgrzaną patelnię wlej masę i smaż z obu stron pod przykryciem. Omleta podawaj z serkiem wiejskim, połówkami pomidorków i posyp posiekanym szczypiorkiem.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Placuszki czekoladowe na mące migdałowej bez laktozy", 534.0f, 20.5f, 9.3f, 45.1f, "Wszystkie składniki wymieszaj. Na rozgrzaną patelnię nakładaj łyżką placuszki i smaż z obu stron na małym ogniu.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Koktajl owsiany z borówkami i gruszką", 268.0f, 1.5f, 34.9f, 13.3f, "Zblenduj wszystkie składniki", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Naleśniki jaglane z hummusem i wędliną", 609.0f, 28.8f, 65.5f, 26.0f, "Do miski wrzuć jajko, mąkę, napój roślinny i całość zblenduj na gładką masę. Odstaw na kilka minut do lodówki, następnie przemieszaj. Na rozgrzanej patelni usmaż naleśniki. Naleśniki posmaruj hummusem i dodaj resztę składników.", 1, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Naleśniki bez laktozy z dżemem truskawkowym", 402.0f, 18.0f, 64.3f, 8.4f, "Mleko wlej do miski, dodaj wodę gazowaną, jaja kurze, mąkę i sól. Wszystko wymieszaj/zmiksuj. Rozgrzej patelnię, nalewaj porcje ciasta i smaż bez tłuszczu z obu stron na złoty kolor. Naleśniki smaruj dżemem.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Naleśniki bez laktozy z dżemem morelowym", 403.0f, 18.0f, 64.6f, 8.4f, "Mleko wlej do miski, dodaj wodę gazowaną, jaja kurze, mąkę i sól. Wszystko wymieszaj/zmiksuj. Rozgrzej patelnię, nalewaj porcje ciasta i smaż bez tłuszczu z obu stron na złoty kolor. Naleśniki smaruj dżemem.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Tortilla pełnoziarnista z pastą jajeczno-twarogową", 443.0f, 25.6f, 39.4f, 20.8f, "Jajko ugotuj na twardo. Do miski wrzuć twaróg, jajko, majonez, musztardę i całość rozgnieć widelcem na gładką masę. Przypraw do smaku. Dodaj posiekany szczypiorek i wymieszaj. Tortillę podgrzej na suchej patelni, posmaruj pastą, dodaj roszponkę i zawiń. Zgrilluj z obu stron. Podawaj z pomidorkami.", 0, 1, 1, "breakfast"));
        mealRepository.save(new Meal("Owsianka bezglutenowa na napoju roślinnym z odżywką", 600.0f, 32.7f, 62.8f, 25.7f, "Płatki zalej napojem roślinnym i ustaw na małym ogniu. Zagotuj, dopraw solą i wymieszaj. Zmniejsz ogień, gotuj jeszcze kilka minut do miękkości, co jakiś czas mieszając. Owsiankę wymieszaj z miodem i odżywką (w razie potrzeby dolej trochę wody). Podawaj z pozostałymi składnikami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Owsianka bezglutenowa i bez laktozy z malinami", 414.0f, 19.5f, 57.3f, 14.9f, "Płatki wsyp do garnka, wlej mleko i gotuj do miękkości. Podawaj wraz z owocami i masłem orzechowym.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Energetyczna, kawowa owsianka bez glutenu", 651.0f, 37.2f, 98.4f, 13.6f, "Mleko i kawę wlej do garnka, wsyp płatki i ustaw na średnim ogniu. Gotuj przez kilka minut, mieszając co jakiś czas. Dodaj szczyptę soli. Kiedy płatki będą miękkie, dorzuć do owsianki banana oraz rodzynki. Owsiankę podawaj ze skyrem i dodaj pozostałe składniki.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Owsianka bezglutenowa z bananem", 501.0f, 19.0f, 71.9f, 16.6f, "Płatki ugotuj na mleku. Owsiankę podawaj z pozostałymi składnikami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Ryż z borówkami i jogurtem kokosowym", 318.0f, 4.0f, 64.0f, 3.3f, "Ryż ugotuj wg wskazówek na opakowaniu. Owoce wymieszaj z jogurtem i miodem. Ugotowany ryż podawaj owocami.", 0, 1, 1, "breakfast"));

        mealRepository.save(new Meal("Musli bez laktozy", 471.0f, 14.5f, 59.9f, 21.6f, "Owoce obierz i pokrój na małe kawałki. Wymieszaj wszystkie składniki.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Jaglanka bez laktozy z owocami", 422.0f, 17.1f, 52.9f, 16.5f, "Kaszę opłucz na sitku i ugotuj na mleku. Gdy kasza wchłonie mleko, przełóż jaglankę do miski i dodaj pozostałe składniki.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Jaglanka z bananem bez laktozy", 446.0f, 15.6f, 62.5f, 16.2f, "Kaszę przepłucz na sitku i ugotuj na mleku. Następnie zmiksuj z bananem. Posyp posiekaną czekoladą i polej masłem.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Ryżanka truskawkowa bez laktozy", 423.0f, 14.2f, 67.1f, 12.7f, "Ryż ugotuj na mleku. Owoce pokrój w kostkę. Orzechy posiekaj i udekoruj nimi ryżankę.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Twarożek bez laktozy z pieczywem", 266.0f, 23.8f, 19.4f, 10.5f, "Z podanych składników przygotuj kanapki.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Musli z jogurtem bez laktozy i kiwi", 337.0f, 12.3f, 47.4f, 12.5f, "Wymieszaj wszystkie składniki.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Kasza z cukinią i serem bez laktozy", 457.0f, 12.2f, 40.5f, 29.2f, "Kaszę ugotuj. Cebulę usmaż na oleju. Dodaj resztę składników. Całość połącz z kaszą.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Ryż bez laktozy z sosem truskawkowym", 384.0f, 14.6f, 69.2f, 6.6f, "Ryż ugotuj na mleku, co jakiś czas mieszając. Truskawki zmiksuj z jogurtem. Ugotowany ryż podawaj z sosem truskawkowym.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Owsianka nesquik z owocami bez laktozy", 516.0f, 19.7f, 80.0f, 14.6f, "Płatki ugotuj na mleku. Podawaj z dodatkami.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Jaglanka bez laktozy z musem truskawkowym", 419.0f, 17.3f, 61.6f, 13.2f, "Kaszę opłucz pod bieżącą wodą, przelej na sitku wrzątkiem i zalej mlekiem. Gotuj do momentu aż kasza wchłonie cały płyn. Truskawki podgrzej w garnku na mus. Jaglankę polej musem truskawkowym i masłem orzechowym.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Burakowe naleśniki z jogurtem bez laktozy", 559.0f, 19.8f, 68.9f, 23.8f, "Ugotuj buraka. Podane składniki zblenduj ze sobą i usmaż naleśniki na rozgrzanej patelni. Na wierzch naleśników nałóż kleks jogurtu.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Musli z mandarynką i jogurtem bez laktozy", 314.0f, 9.7f, 57.6f, 6.6f, "Mandarynki obierz i podziel na małe kawałki. Wymieszaj wszystkie składniki.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowy wrap z drobiem i sosem bez laktozy", 555.0f, 23.9f, 61.6f, 26.0f, "Mięso pokrój w kostkę, przypraw i podsmaż na patelni. Placki : Mąkę wymieszaj z ziołami, gorącą wodą, oliwą, szczypiorkiem. Zagnieć ciasto. Smaż na rumiano na suchej patelni. Na usmażone placki układaj dodatki. Polej sosem: jogurt + przyprawy + musztarda.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z sosem dyniowym bez laktozy", 504.0f, 14.2f, 75.9f, 17.4f, "Makaron ugotuj al'dente. Paprykę pokrój w kostkę, czosnek posiekaj i warzywa zeszklij na patelni. Przypraw pieprzem i solą. Zblenduj puree z dyni z masłem orzechowym, mlekiem i przyprawami. Na patelnię dodaj ugotowany makaron i wlej sos. Całość wymieszaj. Na talerzu posyp pokruszonym serem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Kanapki z serkiem Almette bez laktozy z tuńczykiem", 422.0f, 25.5f, 47.5f, 16.3f, "Z podanych składników przygotuj kanapki.", 1, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Jesienna owsianka z duszonymi śliwkami bez laktozy", 491.0f, 15.0f, 79.8f, 14.6f, "Płatki zalej gorącą wodą i odstaw do napęcznienia. Następnie gdy płatki wchłoną wodę, dodaj jogurt, kakao, posłodź do smaku i wymieszaj. Śliwki pokrój w kostkę i podduś w garnku z niewielką ilością wody. Dodaj cynamon. Owsiankę podawaj ze śliwkami i posyp orzechami.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Makaron z cukinią z ciecierzycą i serem bez laktozy", 441.0f, 13.5f, 45.1f, 25.2f, "Makaron ugotuj. Cebulę przesmaż na oleju. Dodaj resztę składników. Połącz całość z makaronem.", 0, 1, 0, "dinner"));
        mealRepository.save(new Meal("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy", 542.0f, 21.7f, 91.8f, 10.7f, "Piekarnik nagrzej do temperatury 180°C. Ugotowane ziemniaki przeciśnij przez praskę. Dodaj resztę składników i zagnieć jak ciasto. Uformuj kulki i wyłóż na blachę. Piecz do zarumienienia około 15-20 minut.", 0, 1, 0, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy", 385.0f, 19.4f, 38.6f, 17.0f, "Jajka ugotuj na twardo. Wszystkie składniki zblenduj na pastę. Posmaruj chleb pastą. Podawaj z rzodkiewką, pomidorami i sałatą.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy", 348.0f, 21.0f, 49.3f, 9.3f, "Kaszę i warzywa ugotuj krócej niż to zalecane na opakowaniach. Jajko zmiksuj z jogurtem i przyprawami. Wyłóż do naczynia kaszę, ułóż warzywa i polej jogurtem. Piecz w 180 stopniach przez około 30 minut. Posyp danie szczypiorkiem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem", 417.0f, 36.0f, 49.3f, 10.2f, "Kaszę i warzywa ugotuj krócej niż to zalecane na opakowaniach. Mięso pokrój i usmaż na beztłuszczowej patelni. Jajko zmiksuj z jogurtem i przyprawami. Wyłóż do naczynia kaszę, ułóż warzywa, mięso i polej jogurtem. Piecz w 180 stopniach przez około 30 minut. Posyp danie szczypiorkiem.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy", 510.0f, 13.3f, 67.0f, 22.3f, "Makaron ugotuj wg instrukcji na opakowaniu. Pokrojoną w drobną kostkę kiełbasą przesmaż na oliwie. Warzywa pokrój i dodaj do kiełbasy. Dodaj pozostałe składniki. Połącz całość z makaronem.", 1, 0, 0, "dinner"));
        mealRepository.save(new Meal("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy", 400.0f, 17.3f, 54.0f, 12.7f, "Wszystkie składniki zblenduj. Uformuj kulki, wrzuć do gorącej wody i gotuj 2-3 minuty. Podawaj z owocami i jogurtem.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy", 284.0f, 9.9f, 56.9f, 2.9f, "Piekarnik nagrzej do temperatury 200°C. Batata przekrój na pół. Ułóż na blasze do pieczenia. Piecz 25 minut. Ciecierzycę wypłucz z zalewy, osusz i oprósz przyprawami. Wyłóż ciecierzycę w formie do pieczenia i włóż do piekarnika razem z batatami. Czosnek przeciśnij przez praskę, dodaj do jogurtu. Dopraw. Na wydrążony środek batata wyłóż wszystkie składniki.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Bezglutenowy omlet ryżowy", 318.0f, 10.4f, 33.9f, 16.1f, "Ryż ugotuj. Jajko wbij do miski i ubij. Przypraw do smaku. Pomidora pokrój w kostkę. Do ugotowanego oraz ostudzonego ryżu dodaj ubite jajko, mąkę kukurydzianą i pokrojonego pomidora. Całość delikatnie wymieszaj. Masę przelej na rozgrzany na patelni olej i smaż do uzyskania złotego koloru po obu stronach. Wierzch udekoruj szczypiorkiem.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z tofu", 501.0f, 17.2f, 76.0f, 16.6f, "Makaron i brokuł gotuj. Na rozgrzaną patelnię wlej oliwę i przesmażaj cebulę i tofu. Dodaj ugotowany makaron i brokuł, a także resztę składników mieszając i podsmażając jeszcze 2 minuty.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z bobem", 496.0f, 15.4f, 80.3f, 14.7f, "Makaron ugotuj według instrukcji na opakowaniu. Bób ugotuj i obierz. Na patelni z dodatkiem masła podsmaż cukinię, następnie dodaj bób. Dopraw według uznania. Warzywa wymieszaj z makaronem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Spaghetti bezglutenowe z tofu", 402.0f, 12.4f, 56.6f, 15.0f, "Makaron ugotuj wg instrukcji na opakowaniu. Cebulę zeszklij. Dodaj tofu, a po chwili resztę składników. Duś, aż warzywa będą miękkie. Podawaj wymieszane z makaronem.", 0, 0, 0, "dinner"));
        mealRepository.save(new Meal("Kanapka bezglutenowa z miodem", 148.0f, 0.6f, 31.7f, 1.7f, "Przygotuj kanapkę.", 0, 0, 0, "breakfast"));
        mealRepository.save(new Meal("Naleśnik bezglutenowy z dżemem", 952.0f, 36.8f, 106.7f, 44.7f, "Składniki zmiksuj lub zblenduj (poza dżemem). Patelnie rozgrzej. Wlej część powstałej masy i smaż do zarumienienia z obu stron. Zjedz z dodatkami.", 0, 0, 0, "dinner"));
        //
        mealRepository.save(new Meal("Jabłko w cieście bezglutenowym", 445.0f, 15.7f, 51.9f, 20.9f, "Jabłko obierz, wydrąż (tak, aby w środku jabłek był otwór), pokrój w cienkie plasterki. Mąki, mleko, cukier oraz jajko wymieszaj. Następnie dodaj szczyptę soli i cynamon. Zmiksuj na gładką masę. Plastry jabłka zanurz w cieście i usmaż na oleju.", 1, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowa tortilla z warzywami", 393.0f, 10.4f, 56.9f, 15.7f, "Warzywa pokrój. Tortillę posmaruj oliwą, dodaj sałatę, warzywa i ciecierzycę. Zgrilluj z obu stron.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Placuszki szpinakowe bezglutenowe", 440.0f, 16.1f, 54.9f, 18.1f, "Szpinak zblenduj i połącz z resztą składników (oprócz oleju). Na rozgrzaną patelnię wlej olej i smaż placuszki.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z tofu i serem", 574.0f, 23.8f, 76.0f, 21.7f, "Makaron i brokuł gotuj. Na rozgrzaną patelnię wlej oliwę i przesmażaj cebulę i tofu. Dodaj ugotowany makaron i brokuł, a także resztę składników mieszając i podsmażając jeszcze 2 minuty.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Tost bezglutenowy z serem i warzywami", 388.0f, 13.1f, 54.0f, 11.7f, "Chleb opiecz w tosterze. Na ciepły tost połóż plasterki sera i ogórka.", 1, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Burger vege z bagietką bezglutenową", 448.0f, 12.8f, 79.3f, 10.0f, "Piekarnik nagrzej na 200 stopni, użyć tryb termoobieg Marchew, pietruszkę, ziemniak, seler obierz, pokrój, ułóż na blaszce wyłożonej papierem i piec przez 25 minut Soczewicę ugotuj. Warzywa zblenduj i połącz z soczewicą i olejem. dodaj sól, pieprz, płatki i paprykę. Z masy uformuj 3 kotlety i piec je w piekarniku przez 10 minut w trybie termoobiegu. Bagietkę podpiecz, przekrój i posmaruj majonezem. Na połówce bułki ułóż liść sałaty, warzywa i kotlet. Połóż drugą połówkę bagietki.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Pieczone bezglutenowe kulki ziemniaczane", 479.0f, 14.5f, 92.1f, 7.5f, "Piekarnik nagrzej do temperatury 180°C. Ugotowane ziemniaki przeciśnij przez praskę. Dodaj resztę składników i zagnieć jak ciasto. Uformuj kulki i wyłóż na blachę. Piecz do zarumienienia około 15-20 minut.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z miso i kurczakiem", 414.0f, 29.2f, 44.2f, 13.1f, "Makaron ugotuj według instrukcji na opakowaniu. Na patelni z dodatkiem oleju podsmaż papryczki chili, następnie dodaj miso, sos sojowy oraz przyprawy. Mięso podsmaż, następnie dodaj do sosu. Całość wymieszaj z makaronem i posyp szczypiorkiem.", 1, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Kanapki bezglutenowe z hummusem dyniowym", 353.0f, 10.5f, 57.7f, 9.2f, "Do miski wrzuć puree z dyni, ciecierzycę, tahini, dodaj sok z cytryny i przyprawy. Całość zlenduj na gładką masę. W razie potrzeby dolej trochę wody, aby powstała gładka konsystencja. Z podanych składników przygotuj kanapki.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z leczo pomidorowym", 545.0f, 31.5f, 78.8f, 13.3f, "Makaron ugotuj według instrukcji na opakowaniu. Mięso z piersi kurczaka pokrój na kawałki i usmaż, następnie dodaj pokrojoną cukinię. Całość zalej passatą, dopraw według uznania.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Pasta twarogowa z pieczywem bezglutenowym", 283.0f, 23.4f, 36.2f, 4.8f, "Twaróg zmiksuj z jogurtem, bazylią i pietruszką. Dopraw solą i pieprzem. Twarożek podawaj z pieczywem, sałatą i warzywami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Kokosowa owsianka bezglutenowa z jagodami", 478.0f, 18.0f, 71.7f, 15.7f, "Płatki owsiane gotuj na mleku przez około 5 minut. Dodaj wiórki kokosowe. Gotową owsiankę udekoruj jagodami i suszonymi morelami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowa kanapka z kremem czekoladowym", 241.0f, 3.7f, 37.7f, 8.7f, "Całość zblenduj. Podawaj z chlebem.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z zielonymi warzywami", 337.0f, 7.6f, 43.8f, 16.3f, "Makaron ugotuj wg zaleceń na opakowaniu. Odetnij zdrewniałe końce od szparagów. Pokrój szparagi i cukinię. Bób ugotuj i obierz ze skórki. Na patelni rozgrzej oliwę i wrzuć szparagi oraz cukinię. Dodaj przeciśnięty przez praskę czosnek. Makaron odcedź i przełóż na patelnię razem z bobem. Dopraw do smaku.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z łososiem i orzechami", 613.0f, 25.5f, 78.9f, 23.9f, "Makaron i brokuł ugotuj. Na rozgrzaną patelnię wlej oliwę i przesmażaj cebulę i łososia. Dodaj ugotowany makaron i brokuł, a także resztę składników mieszając i podsmażając jeszcze 2 minuty.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Spaghetti bezglutenowe z cukinią i krewetkami", 444.0f, 28.8f, 58.0f, 12.6f, "Makaron ugotuj wg instrukcji na opakowaniu. Cebulę zeszklij. Warzywa pokrój i dodaj do cebuli. Dodaj krewetki, a po chwili resztę składników. Duś, aż warzywa będą miękkie. Podawaj wymieszane z makaronem.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Tofu w sosie sojowym z makaronem bezglutenowym", 647.0f, 18.2f, 108.7f, 16.3f, "Makaron ugotuj wg instrukcji na opakowaniu. Tofu pokrój na kawałki, przełóż do miseczki i obtocz w skrobi ziemniaczanej oraz dopraw solą i pieprzem. Następnie wyłóż na patelnię i smaż po 2-3 minuty z każdej strony. Na tą samą patelnię dodaj czosnek oraz cebulę. Sos sojowy wymieszaj z wodą i syropem klonowym i przelej na patelnię. Następnie dodaj wcześniej usmażone tofu.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z twarogiem i truskawkami", 527.0f, 26.0f, 92.6f, 6.9f, "Makaron ugotuj według instrukcji na opakowaniu. Twaróg wymieszaj z jogurtem i miodem, następnie z makaronem. Dodaj umyte i pokrojone truskawki.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Wysokobiałkowa owsianka bezglutenowa z owocami", 578.0f, 34.9f, 75.7f, 15.8f, "Płatki zalej gorącą wodą i odstaw do napęcznienia. Wymieszaj z jogurtem i odżywką. Dodaj owoce i posyp posiekanymi orzechami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Makaron bezglutenowy z mozzarellą i pomidorami", 585.0f, 25.2f, 74.5f, 22.1f, "Makaron ugotuj wg wskazówek na opakowaniu. Warzywa pokrój. Zioła posiekaj. Ser pokrój w kostkę. Wszystkie składniki ze sobą wymieszaj.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy ze szpinakiem i pieczarkami", 426.0f, 31.3f, 60.5f, 8.4f, "Makaron ugotuj. Na rozgrzaną patelnię dodaj oliwę i pokrojonego kurczaka. Gdy kurczak będzie prawie gotowy dorzuć na patelnię resztę składników. Kiedy wszystko zmięknie połącz z makaronem.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z sosem dyniowym i papryką", 518.0f, 18.0f, 74.5f, 18.0f, "Makaron ugotuj al'dente. Paprykę pokrój w kostkę, czosnek posiekaj i warzywa zeszklij na patelni. Przypraw pieprzem i solą. Zblenduj puree z dyni z masłem orzechowym, mlekiem i przyprawami. Na patelnię dodaj ugotowany makaron i wlej sos. Całość wymieszaj. Na talerzu posyp parmezanem.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy w sosie z sera pleśniowego", 525.0f, 13.1f, 66.7f, 23.3f, "Świeże zioła posiekaj. Zostaw część na później. Wszystkie składniki włóż do garnka i gotuj przez 15 min. na średnim ogniu, pod przykryciem od czasu do czasu mieszając. Na dnie pozostanie sos. Zdejmij danie z płyty i pozostaw na chwilę. Po tym czasie zamieszaj. Dodaj pozotałą część ziół.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Makaron bezglutenowy z łososiem i słonecznikiem", 588.0f, 25.2f, 76.8f, 21.7f, "Makaron i brokuł ugotuj. Na rozgrzaną patelnię wlej oliwę i przesmażaj cebulę i łososia. Dodaj ugotowany makaron i brokuł, a także resztę składników mieszając i podsmażając jeszcze 2 minuty.", 1, 0, 1, "dinner"));
        mealRepository.save(new Meal("Pasta z cukinii i fasoli z pieczywem bezglutenowym", 477.0f, 13.8f, 66.7f, 18.5f, "Fasolę odsącz z zalewy. Cebulę obierz i pokrój w plastry. Cukinię opłucz i zetrzyj na tarce. Na rozgrzanym oleju podsmaż cebulę, a następnie dodaj startą cukinię. Smaż na małym ogniu, ciągle mieszając aż cukinia zmięknie a woda odparuje. Ściągnij z patelni i odcedź cukinię na sitku. Do ostudzonej cukinii dodaj pozostałe składniki: suszone pomidory, sól, pieprz, szczyptę kurkumy i fasolę. Wszystko zmiksuj na gładką masę. Podawaj z pieczywem.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Bezglutenowe spaghetti bolognese z mięsem drobiowym", 596.0f, 34.9f, 89.5f, 14.3f, "Makaron ugotuj wg instrukcji na opakowaniu. Cebulę i czosnek posiekaj i zeszklij na patelni. Dodaj mięso i przypraw do smaku. Marchew zetrzyj i wrzuć na patelnię. Dodaj resztę składników. Duś, aż warzywa będą miękkie. Całość podawaj z makaronem i posyp posiekaną natką pietruszki.", 1, 0, 1, "dinner"));
        mealRepository.save(new Meal("Bezglutenowy makaron w sosie pomidorowym z falafelem", 647.0f, 17.8f, 105.4f, 19.7f, "Makaron ugotuj według instrukcji na opakowaniu. Odcedzoną ciecierzycę oraz sól, cebulę, czosnek i sodę zblenduj, aż ciecierzyca zacznie się lepić, kleić. Pod koniec dodaj natkę pietruszki, dopraw według uznania. Formuj małe kuleczki (wielkości małego orzecha włoskiego) lub placuszki i odkładaj na talerz. Rozgrzej olej do ok. 160 stopni C, wkładaa porcjami kulki z ciecierzycy i smaż po około 3 minuty z każdej strony, w połowie smażenia przewrócić na drugą stronię. Na patelni na której smażą się falafele, wlej passatę. Dopraw i trzymaj na ogniu przez kilka minut. Gotowy sos podaj z makaronem.", 0, 0, 1, "dinner"));
        mealRepository.save(new Meal("Owsianka bezglutenowa na napoju roślinnym z bananem", 496.0f, 17.9f, 68.0f, 17.8f, "Płatki ugotuj na mleku roślinnym. Owsiankę podawaj z pozostałymi składnikami.", 0, 0, 1, "breakfast"));
        mealRepository.save(new Meal("Pasta z pieczonego batata na pieczywie bezglutenowym", 247.0f, 4.9f, 46.5f, 4.5f, "Piekarnik nagrzej do temperatury 200°C. Batata i dynię obierz i pokrój. Wyłóż do naczynia do zapiekania Piecz 25 min. Cebulę pokrój w kostkę i zeszklij na patelni. Upieczone warzywa zmiksuj z cebulą i ciecierzycą na gładką masę. Dopraw do smaku. Podawaj z pieczywem.", 0, 0, 1, "breakfast"));


        ingredientRepository.save(new Ingredient("Makaron tagliatelle"));
        ingredientRepository.save(new Ingredient("Mięso z piersi kurczaka, bez skóry"));
        ingredientRepository.save(new Ingredient("Cebula"));
        ingredientRepository.save(new Ingredient("Czosnek"));
        ingredientRepository.save(new Ingredient("Pieczarka"));
        ingredientRepository.save(new Ingredient("Pesto zielone z bazylii"));
        ingredientRepository.save(new Ingredient("Śmietana 18%"));
        ingredientRepository.save(new Ingredient("Oliwa z oliwek"));
        ingredientRepository.save(new Ingredient("Ser Parmezan"));
        ingredientRepository.save(new Ingredient("Rukola"));
        ingredientRepository.save(new Ingredient("Kasza gryczana"));
        ingredientRepository.save(new Ingredient("Brokuły"));
        ingredientRepository.save(new Ingredient("Marchew"));
        ingredientRepository.save(new Ingredient("Sos sojowy"));
        ingredientRepository.save(new Ingredient("Sos teriyaki"));
        ingredientRepository.save(new Ingredient("Sezam, nasiona"));
        ingredientRepository.save(new Ingredient("Makaron penne"));
        ingredientRepository.save(new Ingredient("Koncentrat pomidorowy 30%"));
        ingredientRepository.save(new Ingredient("Śmietanka 30%"));
        ingredientRepository.save(new Ingredient("Ser mozzarella"));
        ingredientRepository.save(new Ingredient("Natka pietruszki"));
        ingredientRepository.save(new Ingredient("Oregano suszone"));
        ingredientRepository.save(new Ingredient("Pieprz czarny mielony"));
        ingredientRepository.save(new Ingredient("Papryka słodka (mielona)"));
        ingredientRepository.save(new Ingredient("Kasza bulgur"));
        ingredientRepository.save(new Ingredient("Wołowina, polędwica"));
        ingredientRepository.save(new Ingredient("Jogurt naturalny 2%"));
        ingredientRepository.save(new Ingredient("Koper ogrodowy"));
        ingredientRepository.save(new Ingredient("Sól biała"));
        ingredientRepository.save(new Ingredient("Ryż biały"));
        ingredientRepository.save(new Ingredient("Halibut biały, świeży"));
        ingredientRepository.save(new Ingredient("Sok cytrynowy"));
        ingredientRepository.save(new Ingredient("Por"));
        ingredientRepository.save(new Ingredient("Kurki"));
        ingredientRepository.save(new Ingredient("Szczypiorek"));
        ingredientRepository.save(new Ingredient("Kurkuma mielona"));
        ingredientRepository.save(new Ingredient("Makaron bezglutenowy, kukurydziany"));
        ingredientRepository.save(new Ingredient("Śmietana 18% bez laktozy"));
        ingredientRepository.save(new Ingredient("Dynia"));
        ingredientRepository.save(new Ingredient("Masło klarowane (ghee)"));
        ingredientRepository.save(new Ingredient("Bulion warzywny (domowy)"));
        ingredientRepository.save(new Ingredient("Mleko 1,5% tłuszczu"));
        ingredientRepository.save(new Ingredient("Śmietana 12%"));
        ingredientRepository.save(new Ingredient("Curry (przyprawa)"));
        ingredientRepository.save(new Ingredient("Makaron pełnoziarnisty"));
        ingredientRepository.save(new Ingredient("Tofu naturalne"));
        ingredientRepository.save(new Ingredient("Suszone pomidory"));
        ingredientRepository.save(new Ingredient("Pomidor koktajlowy"));
        ingredientRepository.save(new Ingredient("Oliwa z oliwek czosnkowa, aromatyzowana"));
        ingredientRepository.save(new Ingredient("Zioła prowansalskie"));
        ingredientRepository.save(new Ingredient("Olej kokosowy"));
        ingredientRepository.save(new Ingredient("Mięso mielone z indyka"));
        ingredientRepository.save(new Ingredient("Imbir, świeży"));
        ingredientRepository.save(new Ingredient("Ryż basmati"));
        ingredientRepository.save(new Ingredient("Cukinia"));
        ingredientRepository.save(new Ingredient("Jajko kurze (całe)"));
        ingredientRepository.save(new Ingredient("Pestki dyni"));
        ingredientRepository.save(new Ingredient("Papryka słodka, wędzona"));
        ingredientRepository.save(new Ingredient("Fasola szparagowa"));
        ingredientRepository.save(new Ingredient("Papryka czerwona"));
        ingredientRepository.save(new Ingredient("Mleczko kokosowe (w puszce)"));
        ingredientRepository.save(new Ingredient("Soczewica czerwona, suche nasiona"));
        ingredientRepository.save(new Ingredient("Kasza jaglana"));
        ingredientRepository.save(new Ingredient("Mąka orkiszowa"));
        ingredientRepository.save(new Ingredient("Tymianek suszony"));
        ingredientRepository.save(new Ingredient("Kapusta kiszona"));
        ingredientRepository.save(new Ingredient("Olej rzepakowy (obniżona zawartość kwasu erukowego)"));
        ingredientRepository.save(new Ingredient("Łosoś, świeży"));
        ingredientRepository.save(new Ingredient("Ciecierzyca, w zalewie"));
        ingredientRepository.save(new Ingredient("Ogórek"));
        ingredientRepository.save(new Ingredient("Roszponka"));
        ingredientRepository.save(new Ingredient("Olej lniany tłoczony na zimno"));
        ingredientRepository.save(new Ingredient("Halloumi"));
        ingredientRepository.save(new Ingredient("Pomidor"));
        ingredientRepository.save(new Ingredient("Awokado"));
        ingredientRepository.save(new Ingredient("Soczewica gotowana na parze z puszki"));
        ingredientRepository.save(new Ingredient("Papryka chili (mielona)"));
        ingredientRepository.save(new Ingredient("Ziemniaki, średnio"));
        ingredientRepository.save(new Ingredient("Zielony groszek, konserwowy"));
        ingredientRepository.save(new Ingredient("Passata pomidorowa"));
        ingredientRepository.save(new Ingredient("Majeranek"));
        ingredientRepository.save(new Ingredient("Komosa ryżowa"));
        ingredientRepository.save(new Ingredient("Buraki gotowane"));
        ingredientRepository.save(new Ingredient("Olej lniany"));
        ingredientRepository.save(new Ingredient("Mąka ryżowa"));
        ingredientRepository.save(new Ingredient("Ziemniaki, wczesne"));
        ingredientRepository.save(new Ingredient("Pietruszka"));
        ingredientRepository.save(new Ingredient("Bulion drobiowy (domowy)"));
        ingredientRepository.save(new Ingredient("Mięso wołowe, mielone"));
        ingredientRepository.save(new Ingredient("Świeża bazylia"));
        ingredientRepository.save(new Ingredient("Woda"));
        ingredientRepository.save(new Ingredient("Bazylia suszona"));
        ingredientRepository.save(new Ingredient("Skrobia ziemniaczana"));
        ingredientRepository.save(new Ingredient("Napój owsiany"));
        ingredientRepository.save(new Ingredient("Gałka muszkatołowa, mielona"));
        ingredientRepository.save(new Ingredient("Płatki drożdżowe"));
        ingredientRepository.save(new Ingredient("Makaron gryczany"));
        ingredientRepository.save(new Ingredient("Bataty"));
        ingredientRepository.save(new Ingredient("Dorsz"));
        ingredientRepository.save(new Ingredient("Jabłko"));
        ingredientRepository.save(new Ingredient("Czosnek granulowany"));
        ingredientRepository.save(new Ingredient("Czerwona cebula"));
        ingredientRepository.save(new Ingredient("Kukurydza konserwowa"));
        ingredientRepository.save(new Ingredient("Tortilla kukurydziana"));
        ingredientRepository.save(new Ingredient("Hummus klasyczny"));
        ingredientRepository.save(new Ingredient("Mąka owsiana pełnoziarnista, bezglutenowa"));
        ingredientRepository.save(new Ingredient("Sól himalajska"));
        ingredientRepository.save(new Ingredient("Sałata lodowa"));
        ingredientRepository.save(new Ingredient("Ogórek kiszony"));
        ingredientRepository.save(new Ingredient("Jogurt grecki"));
        ingredientRepository.save(new Ingredient("Musztarda"));
        ingredientRepository.save(new Ingredient("Tofu wędzone"));
        ingredientRepository.save(new Ingredient("Kawa, napar bez cukru"));
        ingredientRepository.save(new Ingredient("Mleko 2% tłuszczu"));
        ingredientRepository.save(new Ingredient("Banan"));
        ingredientRepository.save(new Ingredient("Białko WPC 82 KFD (czekoladowe)"));
        ingredientRepository.save(new Ingredient("Masło orzechowe (bez dodatku soli)"));
        ingredientRepository.save(new Ingredient("Kakao 16% (proszek)"));
        ingredientRepository.save(new Ingredient("Cynamon (mielony)"));
        ingredientRepository.save(new Ingredient("Płatki owsiane"));
        ingredientRepository.save(new Ingredient("Bułka pełnoziarnista"));
        ingredientRepository.save(new Ingredient("Burrata"));
        ingredientRepository.save(new Ingredient("Czekolada gorzka"));
        ingredientRepository.save(new Ingredient("Śliwki"));
        ingredientRepository.save(new Ingredient("Orzechy pistacjowe"));
        ingredientRepository.save(new Ingredient("Skyr naturalny pitny"));
        ingredientRepository.save(new Ingredient("Płatki jaglane"));
        ingredientRepository.save(new Ingredient("Masło orzechowe GoOn proteinowe słony karmel"));
        ingredientRepository.save(new Ingredient("Maliny, mrożone"));
        ingredientRepository.save(new Ingredient("Grani twarożek naturalny"));
        ingredientRepository.save(new Ingredient("Mąka gryczana"));
        ingredientRepository.save(new Ingredient("Proszek do pieczenia"));
        ingredientRepository.save(new Ingredient("Erytrytol"));
        ingredientRepository.save(new Ingredient("Skyr waniliowy, Piątnica"));
        ingredientRepository.save(new Ingredient("Odżywka białkowa (na bazie mleka)"));
        ingredientRepository.save(new Ingredient("Brzoskwinia"));
        ingredientRepository.save(new Ingredient("Orzechy włoskie"));
        ingredientRepository.save(new Ingredient("Suszone pomidory, w zalewie olejowej"));
        ingredientRepository.save(new Ingredient("Chleb bezglutenowy"));
        ingredientRepository.save(new Ingredient("Bułka grahamka"));
        ingredientRepository.save(new Ingredient("Płatki owsiane bezglutenowe"));
        ingredientRepository.save(new Ingredient("Serek wiejski, ziarnisty"));
        ingredientRepository.save(new Ingredient("Orzechy nerkowca"));
        ingredientRepository.save(new Ingredient("Puree dynia"));
        ingredientRepository.save(new Ingredient("Tahini"));
        ingredientRepository.save(new Ingredient("Chleb żytni jasny"));
        ingredientRepository.save(new Ingredient("Olej rzepakowy uniwersalny"));
        ingredientRepository.save(new Ingredient("Skyr, naturalny"));
        ingredientRepository.save(new Ingredient("Maliny"));
        ingredientRepository.save(new Ingredient("Ksylitol"));
        ingredientRepository.save(new Ingredient("Len, mielony"));
        ingredientRepository.save(new Ingredient("Musli z owocami suszonymi"));
        ingredientRepository.save(new Ingredient("Winogrona"));
        ingredientRepository.save(new Ingredient("Jogurt naturalny kremowy bez laktozy"));
        ingredientRepository.save(new Ingredient("Otręby pszenne"));
        ingredientRepository.save(new Ingredient("Płatki migdałowe"));
        ingredientRepository.save(new Ingredient("Miód pszczeli"));
        ingredientRepository.save(new Ingredient("Jogurt kokosowy"));
        ingredientRepository.save(new Ingredient("Masło ekstra bez laktozy"));
        ingredientRepository.save(new Ingredient("Twaróg półtłusty bez laktozy"));
        ingredientRepository.save(new Ingredient("Budyń w proszku"));
        ingredientRepository.save(new Ingredient("Wiórki kokosowe"));
        ingredientRepository.save(new Ingredient("Ser twarogowy chudy"));
        ingredientRepository.save(new Ingredient("Serek Almette bez laktozy"));
        ingredientRepository.save(new Ingredient("Sałata"));
        ingredientRepository.save(new Ingredient("Ogórek konserwowy"));
        ingredientRepository.save(new Ingredient("Almette serek śmietankowy, Hochland"));
        ingredientRepository.save(new Ingredient("Płynne białko jaj kurzych"));
        ingredientRepository.save(new Ingredient("Szpinak"));
        ingredientRepository.save(new Ingredient("Serek wiejski lekki"));
        ingredientRepository.save(new Ingredient("Mąka migdałowa"));
        ingredientRepository.save(new Ingredient("Mleko bez laktozy 3,2 %"));
        ingredientRepository.save(new Ingredient("Borówki amerykańskie"));
        ingredientRepository.save(new Ingredient("Gruszka"));
        ingredientRepository.save(new Ingredient("Mąka jaglana"));
        ingredientRepository.save(new Ingredient("Mleko sojowe"));
        ingredientRepository.save(new Ingredient("Szynka z indyka"));
        ingredientRepository.save(new Ingredient("Mleko bez laktozy 1,5%"));
        ingredientRepository.save(new Ingredient("Woda gazowana"));
        ingredientRepository.save(new Ingredient("Mąka pszenna typ 550"));
        ingredientRepository.save(new Ingredient("Dżem truskawkowy, niskosłodzony"));
        ingredientRepository.save(new Ingredient("Dżem morelowy, niskosłodzony"));
        ingredientRepository.save(new Ingredient("Majonez lekki, Winiary"));
        ingredientRepository.save(new Ingredient("Tortilla pełnoziarnista"));
        ingredientRepository.save(new Ingredient("Napój migdałowy"));
        ingredientRepository.save(new Ingredient("Odżywka białkowa wegańska - AllNutrition Vegan Protein"));
        ingredientRepository.save(new Ingredient("Orzechy laskowe"));
        ingredientRepository.save(new Ingredient("Rodzynki"));
        ingredientRepository.save(new Ingredient("Mleko UHT 1,5%"));

        ingredientRepository.save(new Ingredient("Orzechy brazylijskie"));
        ingredientRepository.save(new Ingredient("Serek wiejski bez laktozy"));
        ingredientRepository.save(new Ingredient("Chleb żytni razowy"));
        ingredientRepository.save(new Ingredient("Kiwi"));
        ingredientRepository.save(new Ingredient("Musli z rodzynkami i orzechami"));
        ingredientRepository.save(new Ingredient("Len, nasiona"));
        ingredientRepository.save(new Ingredient("Ser gouda bez laktozy"));
        ingredientRepository.save(new Ingredient("Kulki czekoladowe Nesquik"));
        ingredientRepository.save(new Ingredient("Mrożone truskawki"));
        ingredientRepository.save(new Ingredient("Truskawki"));
        ingredientRepository.save(new Ingredient("Burak"));
        ingredientRepository.save(new Ingredient("Mandarynki"));
        ingredientRepository.save(new Ingredient("Mięso z piersi indyka, bez skóry"));
        ingredientRepository.save(new Ingredient("Favita Ser sałatkowo-kanapkowy bez laktozy"));
        ingredientRepository.save(new Ingredient("Tuńczyk w wodzie"));
        ingredientRepository.save(new Ingredient("Rzodkiewka"));
        ingredientRepository.save(new Ingredient("Kalafior"));
        ingredientRepository.save(new Ingredient("Kiełbasa żywiecka"));
        ingredientRepository.save(new Ingredient("Śliwki, suszone"));
        ingredientRepository.save(new Ingredient("Pomidory z puszki (krojone)"));
        ingredientRepository.save(new Ingredient("Mąka kukurydziana"));
        ingredientRepository.save(new Ingredient("Bób"));
        ingredientRepository.save(new Ingredient("Masło ekstra"));
        ingredientRepository.save(new Ingredient("Nasiona słonecznika"));
        ingredientRepository.save(new Ingredient("Makaron ryżowy"));
        ingredientRepository.save(new Ingredient("Cukier"));
        ingredientRepository.save(new Ingredient("Mąka kokosowa"));
        ingredientRepository.save(new Ingredient("Mąka z ciecierzycy"));
        ingredientRepository.save(new Ingredient("Ciecierzyca (ugotowana)"));
        ingredientRepository.save(new Ingredient("Chleb tostowy bezglutenowy"));
        ingredientRepository.save(new Ingredient("Ser Gouda, tłusty"));
        ingredientRepository.save(new Ingredient("Ziemniaki późne"));
        ingredientRepository.save(new Ingredient("Seler korzeniowy"));
        ingredientRepository.save(new Ingredient("Ogórek kwaszony"));
        ingredientRepository.save(new Ingredient("Majonez z tofu"));
        ingredientRepository.save(new Ingredient("Ostra papryka mielona"));
        ingredientRepository.save(new Ingredient("Bagietka bezglutenowa"));
        ingredientRepository.save(new Ingredient("Papryczka chili, czerwona"));
        ingredientRepository.save(new Ingredient("Miso"));
        ingredientRepository.save(new Ingredient("Imbir mielony"));
        ingredientRepository.save(new Ingredient("Kolendra, suszone liście"));
        ingredientRepository.save(new Ingredient("Czarne jagody"));
        ingredientRepository.save(new Ingredient("Morele, suszone"));
        ingredientRepository.save(new Ingredient("Daktyle suszone"));
        ingredientRepository.save(new Ingredient("Szparagi"));
        ingredientRepository.save(new Ingredient("Łosoś wędzony"));
        ingredientRepository.save(new Ingredient("Krewetki surowe"));
        ingredientRepository.save(new Ingredient("Syrop klonowy"));
        ingredientRepository.save(new Ingredient("Ser twarogowy półtłusty"));
        ingredientRepository.save(new Ingredient("Jogurt naturalny 2% tłuszczu"));
        ingredientRepository.save(new Ingredient("Odżywka białkowa wegańska Olimp"));
        ingredientRepository.save(new Ingredient("Mascarpone"));
        ingredientRepository.save(new Ingredient("Niebieski ser pleśniowy"));
        ingredientRepository.save(new Ingredient("Fasola biała, konserwowa"));
        ingredientRepository.save(new Ingredient("Soda oczyszczona"));

        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Makaron tagliatelle"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Pieczarka"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Pesto zielone z bazylii"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Śmietana 18%"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Ser Parmezan"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z pesto, pieczarkami i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Rukola"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Kasza gryczana"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Marchew"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Sos teriyaki"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kurczak teriyaki z kaszą i brokułem"), ingredientRepository.findIngredientByIngredientName("Sezam, nasiona"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Makaron penne"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Koncentrat pomidorowy 30%"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Śmietanka 30%"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Ser mozzarella"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron wysokobiałkowy z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Papryka słodka (mielona)"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Kasza bulgur"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Wołowina, polędwica"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny 2%"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Koper ogrodowy"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Stek wołowy z kaszą i brokułami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Halibut biały, świeży"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Sok cytrynowy"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczony halibut z ryżem i brokułem"), ingredientRepository.findIngredientByIngredientName("Koper ogrodowy"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Kasza gryczana"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Por"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Kurki"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Papryka słodka (mielona)"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kaszotto gryczane z kurkami"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kurki"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Śmietana 18% bez laktozy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z kurczakiem i kurkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Dynia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Masło klarowane (ghee)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Bulion warzywny (domowy)"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Mleko 1,5% tłuszczu"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Ser Parmezan"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Śmietana 12%"), 18));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Papryka słodka (mielona)"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Risotto dyniowe z kurczakiem"), ingredientRepository.findIngredientByIngredientName("Curry (przyprawa)"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Makaron pełnoziarnisty"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory"), 21));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek czosnkowa, aromatyzowana"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Zioła prowansalskie"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z tofu i pomidorami"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Olej kokosowy"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Mięso mielone z indyka"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Imbir, świeży"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Indyk z brokułem w sosie sojowym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek czosnkowa, aromatyzowana"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Ryż basmati"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Marchew"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Pestki dyni"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z warzywami i jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Papryka słodka, wędzona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Fasola szparagowa"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Marchew"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Mleczko kokosowe (w puszce)"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Curry (przyprawa)"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Curry z tofu w mleczku kokosowym z ryżem"), ingredientRepository.findIngredientByIngredientName("Papryka słodka (mielona)"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Soczewica czerwona, suche nasiona"), 48));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Kasza jaglana"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Mąka orkiszowa"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Tymianek suszony"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Kapusta kiszona"), 110));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kotlety z soczewicy, kaszy jaglanej z kapustą kiszoną"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy (obniżona zawartość kwasu erukowego)"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Łosoś, świeży"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca, w zalewie"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Ogórek"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Roszponka"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Olej lniany tłoczony na zimno"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Łosoś pieczony z warzywami i chrupkami z ciecierzycy"), ingredientRepository.findIngredientByIngredientName("Papryka słodka (mielona)"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Pieczarka"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Halloumi"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Olej kokosowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Awokado"), 140));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Soczewica gotowana na parze z puszki"), 265));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Zioła prowansalskie"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z soczewicy z halloumi"), ingredientRepository.findIngredientByIngredientName("Papryka chili (mielona)"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Ziemniaki, średnio"), 85));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Marchew"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Zielony groszek, konserwowy"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Soczewica gotowana na parze z puszki"), 265));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Passata pomidorowa"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Gulasz z soczewicy z ziemniakami i groszkiem"), ingredientRepository.findIngredientByIngredientName("Majeranek"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z burakiem, komosą ryżową i pestkami dyni"), ingredientRepository.findIngredientByIngredientName("Komosa ryżowa"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z burakiem, komosą ryżową i pestkami dyni"), ingredientRepository.findIngredientByIngredientName("Ogórek"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z burakiem, komosą ryżową i pestkami dyni"), ingredientRepository.findIngredientByIngredientName("Buraki gotowane"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z burakiem, komosą ryżową i pestkami dyni"), ingredientRepository.findIngredientByIngredientName("Roszponka"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z burakiem, komosą ryżową i pestkami dyni"), ingredientRepository.findIngredientByIngredientName("Pestki dyni"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Sałatka z burakiem, komosą ryżową i pestkami dyni"), ingredientRepository.findIngredientByIngredientName("Olej lniany"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Mięso mielone z indyka"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Mąka ryżowa"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Marchew"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Ziemniaki, wczesne"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Pietruszka"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Bulion drobiowy (domowy)"), 300));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Masło klarowane (ghee)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zupa koperkowa z klopsikami"), ingredientRepository.findIngredientByIngredientName("Koper ogrodowy"), 24));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Mięso wołowe, mielone"), 130));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Masło klarowane (ghee)"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Świeża bazylia"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Koncentrat pomidorowy 30%"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Woda"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Bazylia suszona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Mąka ryżowa"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Skrobia ziemniaczana"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Napój owsiany"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Gałka muszkatołowa, mielona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Płatki drożdżowe"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Zapiekany makaron bezglutenowy"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron gryczany z sosem pomidorowym i bazylią"), ingredientRepository.findIngredientByIngredientName("Makaron gryczany"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron gryczany z sosem pomidorowym i bazylią"), ingredientRepository.findIngredientByIngredientName("Passata pomidorowa"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron gryczany z sosem pomidorowym i bazylią"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron gryczany z sosem pomidorowym i bazylią"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron gryczany z sosem pomidorowym i bazylią"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron gryczany z sosem pomidorowym i bazylią"), ingredientRepository.findIngredientByIngredientName("Bazylia suszona"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Bataty"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Dorsz"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Kapusta kiszona"), 110));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Jabłko"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Marchew"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Sok cytrynowy"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Czosnek granulowany"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryba pieczona z frytkami z batatów i surówką"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Czerwona cebula"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Ogórek"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Kukurydza konserwowa"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Tortilla kukurydziana"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Hummus klasyczny"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla kukurydziana z mozzarellą, hummusem i warzywami"), ingredientRepository.findIngredientByIngredientName("Ser mozzarella"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Mąka owsiana pełnoziarnista, bezglutenowa"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Woda"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Sól himalajska"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Sałata lodowa"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Ogórek kiszony"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Jogurt grecki"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Świeża bazylia"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Musztarda"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wege wrap"), ingredientRepository.findIngredientByIngredientName("Tofu wędzone"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Kawa, napar bez cukru"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Mleko 2% tłuszczu"), 300));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Banan"), 240));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Białko WPC 82 KFD (czekoladowe)"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe (bez dodatku soli)"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kawowy shake proteinowy"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Bułka pełnoziarnista"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Burrata"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Świeża bazylia"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Grzanki z burratą i pomidorkami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka ze śliwkami, czekoladą i odżywką"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka ze śliwkami, czekoladą i odżywką"), ingredientRepository.findIngredientByIngredientName("Mleko 1,5% tłuszczu"), 300));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka ze śliwkami, czekoladą i odżywką"), ingredientRepository.findIngredientByIngredientName("Czekolada gorzka"), 24));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka ze śliwkami, czekoladą i odżywką"), ingredientRepository.findIngredientByIngredientName("Białko WPC 82 KFD (czekoladowe)"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka ze śliwkami, czekoladą i odżywką"), ingredientRepository.findIngredientByIngredientName("Śliwki"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka ze śliwkami, czekoladą i odżywką"), ingredientRepository.findIngredientByIngredientName("Orzechy pistacjowe"), 9));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokokaloryczny shake owocowy z malinami"), ingredientRepository.findIngredientByIngredientName("Banan"), 240));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokokaloryczny shake owocowy z malinami"), ingredientRepository.findIngredientByIngredientName("Skyr naturalny pitny"), 330));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokokaloryczny shake owocowy z malinami"), ingredientRepository.findIngredientByIngredientName("Płatki jaglane"), 35));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokokaloryczny shake owocowy z malinami"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe GoOn proteinowe słony karmel"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokokaloryczny shake owocowy z malinami"), ingredientRepository.findIngredientByIngredientName("Maliny, mrożone"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Grani twarożek naturalny"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Mąka gryczana"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Proszek do pieczenia"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Erytrytol"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe placki białkowe ze skyrem"), ingredientRepository.findIngredientByIngredientName("Skyr waniliowy, Piątnica"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka z odżywką białkową i owocem"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka z odżywką białkową i owocem"), ingredientRepository.findIngredientByIngredientName("Odżywka białkowa (na bazie mleka)"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka z odżywką białkową i owocem"), ingredientRepository.findIngredientByIngredientName("Mleko 1,5% tłuszczu"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka z odżywką białkową i owocem"), ingredientRepository.findIngredientByIngredientName("Brzoskwinia"), 85));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka z odżywką białkową i owocem"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory, w zalewie olejowej"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Kurki"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami na grahamce"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami na grahamce"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory, w zalewie olejowej"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami na grahamce"), ingredientRepository.findIngredientByIngredientName("Kurki"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami na grahamce"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami na grahamce"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jajecznica z kurkami na grahamce"), ingredientRepository.findIngredientByIngredientName("Bułka grahamka"), 65));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 240));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Kurki"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Szakszuka z kurkami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 140));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Banan"), 240));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Odżywka białkowa (na bazie mleka)"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Mleko 2% tłuszczu"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowy omlet owsiany"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z serkiem wiejskim i owocami"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z serkiem wiejskim i owocami"), ingredientRepository.findIngredientByIngredientName("Mleko 2% tłuszczu"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z serkiem wiejskim i owocami"), ingredientRepository.findIngredientByIngredientName("Banan"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z serkiem wiejskim i owocami"), ingredientRepository.findIngredientByIngredientName("Serek wiejski, ziarnisty"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z serkiem wiejskim i owocami"), ingredientRepository.findIngredientByIngredientName("Śliwki"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z serkiem wiejskim i owocami"), ingredientRepository.findIngredientByIngredientName("Orzechy nerkowca"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Puree dynia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca, w zalewie"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Tahini"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Sok cytrynowy"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Chleb żytni jasny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Papryka słodka, wędzona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z hummusem dyniowym i grillowanym tofu"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Puree dynia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Mąka gryczana"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Odżywka białkowa (na bazie mleka)"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Skyr, naturalny"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe gofry dyniowe ze skyrem i owocami"), ingredientRepository.findIngredientByIngredientName("Maliny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Banan"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Puree dynia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Mąka orkiszowa"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Proszek do pieczenia"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Ksylitol"), 14));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Skyr, naturalny"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Maliny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki dyniowe z bananem i tahini"), ingredientRepository.findIngredientByIngredientName("Tahini"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z brzoskiwnią"), ingredientRepository.findIngredientByIngredientName("Kasza jaglana"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z brzoskiwnią"), ingredientRepository.findIngredientByIngredientName("Brzoskwinia"), 85));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z brzoskiwnią"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny 2%"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z brzoskiwnią"), ingredientRepository.findIngredientByIngredientName("Len, mielony"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z winogronem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Musli z owocami suszonymi"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z winogronem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Winogrona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z winogronem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bananowe musli z orzechami włoskimi z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Musli z owocami suszonymi"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bananowe musli z orzechami włoskimi z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Banan"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bananowe musli z orzechami włoskimi z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bananowe musli z orzechami włoskimi z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Banan"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Otręby pszenne"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Płatki migdałowe"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Olej kokosowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananowym jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Maliny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Banan"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Jogurt kokosowy"), 160));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Otręby pszenne"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Płatki migdałowe"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Olej kokosowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Granola z bananem i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Maliny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pestki dyni"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Masło ekstra bez laktozy"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Pestki dyni"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Olej kokosowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kakaowa granola z pestkami dyni i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Jogurt kokosowy"), 160));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Brzoskwinia"), 85));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Twaróg półtłusty bez laktozy"), 115));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Mąka orkiszowa"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Budyń w proszku"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Wiórki kokosowe"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Erytrytol"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Proszek do pieczenia"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy bez laktozy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Brzoskwinia"), 85));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Ser twarogowy chudy"), 125));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Skyr waniliowy, Piątnica"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Mąka orkiszowa"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Budyń w proszku"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Wiórki kokosowe"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Erytrytol"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Proszek do pieczenia"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet sernikowy z brzoskwinią"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Bułka grahamka"), 65));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Serek Almette bez laktozy"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Sałata"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Ogórek konserwowy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy bez laktozy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Czerwona cebula"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Bułka pełnoziarnista"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Almette serek śmietankowy, Hochland"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Sałata"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Czerwona cebula"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger śniadaniowy z jajkiem sadzonym"), ingredientRepository.findIngredientByIngredientName("Ogórek konserwowy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Płynne białko jaj kurzych"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Szpinak"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Mleko 1,5% tłuszczu"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Mąka orkiszowa"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Proszek do pieczenia"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Serek wiejski lekki"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Omlet szpinakowy z białek"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mąka migdałowa"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Proszek do pieczenia"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Erytrytol"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 3,2 %"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki czekoladowe na mące migdałowej bez laktozy"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Koktajl owsiany z borówkami i gruszką"), ingredientRepository.findIngredientByIngredientName("Napój owsiany"), 240));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Koktajl owsiany z borówkami i gruszką"), ingredientRepository.findIngredientByIngredientName("Borówki amerykańskie"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Koktajl owsiany z borówkami i gruszką"), ingredientRepository.findIngredientByIngredientName("Gruszka"), 65));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Koktajl owsiany z borówkami i gruszką"), ingredientRepository.findIngredientByIngredientName("Olej lniany"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Mąka jaglana"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Mleko sojowe"), 130));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Hummus klasyczny"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Roszponka"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Szynka z indyka"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki jaglane z hummusem i wędliną"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 125));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Woda gazowana"), 31));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Mąka pszenna typ 550"), 64));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Dżem truskawkowy, niskosłodzony"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem morelowym"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 125));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem morelowym"), ingredientRepository.findIngredientByIngredientName("Woda gazowana"), 31));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem morelowym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem morelowym"), ingredientRepository.findIngredientByIngredientName("Mąka pszenna typ 550"), 64));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem morelowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśniki bez laktozy z dżemem morelowym"), ingredientRepository.findIngredientByIngredientName("Dżem morelowy, niskosłodzony"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Ser twarogowy chudy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Majonez lekki, Winiary"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Musztarda"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Tortilla pełnoziarnista"), 61));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Roszponka"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tortilla pełnoziarnista z pastą jajeczno-twarogową"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Napój migdałowy"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Odżywka białkowa wegańska - AllNutrition Vegan Protein"), 28));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Orzechy laskowe"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z odżywką"), ingredientRepository.findIngredientByIngredientName("Jabłko"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa i bez laktozy z malinami"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 230));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa i bez laktozy z malinami"), ingredientRepository.findIngredientByIngredientName("Maliny"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa i bez laktozy z malinami"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa i bez laktozy z malinami"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe (bez dodatku soli)"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Mleko 2% tłuszczu"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Kawa, napar bez cukru"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Banan"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Rodzynki"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Skyr, naturalny"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Czekolada gorzka"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Energetyczna, kawowa owsianka bez glutenu"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z bananem"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z bananem"), ingredientRepository.findIngredientByIngredientName("Mleko UHT 1,5%"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z bananem"), ingredientRepository.findIngredientByIngredientName("Banan"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa z bananem"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z borówkami i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z borówkami i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Borówki amerykańskie"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z borówkami i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Jogurt kokosowy"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż z borówkami i jogurtem kokosowym"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 12));

        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli bez laktozy"), ingredientRepository.findIngredientByIngredientName("Maliny, mrożone"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli bez laktozy"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli bez laktozy"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sezam, nasiona"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól himalajska"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z owocami"), ingredientRepository.findIngredientByIngredientName("Kasza jaglana"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z owocami"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z owocami"), ingredientRepository.findIngredientByIngredientName("Borówki amerykańskie"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z owocami"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z owocami"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z owocami"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z bananem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kasza jaglana"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z bananem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z bananem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Banan"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z bananem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Czekolada gorzka"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka z bananem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe (bez dodatku soli)"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryżanka truskawkowa bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryżanka truskawkowa bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 230));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryżanka truskawkowa bez laktozy"), ingredientRepository.findIngredientByIngredientName("Truskawki"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryżanka truskawkowa bez laktozy"), ingredientRepository.findIngredientByIngredientName("Orzechy brazylijskie"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Twarożek bez laktozy z pieczywem"), ingredientRepository.findIngredientByIngredientName("Serek wiejski bez laktozy"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Twarożek bez laktozy z pieczywem"), ingredientRepository.findIngredientByIngredientName("Chleb żytni razowy"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z jogurtem bez laktozy i kiwi"), ingredientRepository.findIngredientByIngredientName("Kiwi"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z jogurtem bez laktozy i kiwi"), ingredientRepository.findIngredientByIngredientName("Musli z rodzynkami i orzechami"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z jogurtem bez laktozy i kiwi"), ingredientRepository.findIngredientByIngredientName("Len, nasiona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z jogurtem bez laktozy i kiwi"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kasza gryczana"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleczko kokosowe (w puszce)"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ser gouda bez laktozy"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza z cukinią i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż bez laktozy z sosem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż bez laktozy z sosem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 230));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż bez laktozy z sosem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Truskawki"), 210));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Ryż bez laktozy z sosem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka nesquik z owocami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 230));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka nesquik z owocami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka nesquik z owocami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kulki czekoladowe Nesquik"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka nesquik z owocami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Maliny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka nesquik z owocami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Orzechy nerkowca"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z musem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Kasza jaglana"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z musem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 230));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z musem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Mrożone truskawki"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jaglanka bez laktozy z musem truskawkowym"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe (bez dodatku soli)"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Burak"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Woda"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mąka pszenna typ 550"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burakowe naleśniki z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z mandarynką i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mandarynki"), 195));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z mandarynką i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Musli z owocami suszonymi"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Musli z mandarynką i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi indyka, bez skóry"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mąka owsiana pełnoziarnista, bezglutenowa"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Woda"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól himalajska"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sałata lodowa"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Czerwona cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ogórek kiszony"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Musztarda"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy wrap z drobiem i sosem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Puree dynia"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleko bez laktozy 1,5%"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe (bez dodatku soli)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Favita Ser sałatkowo-kanapkowy bez laktozy"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Papryka słodka, wędzona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z serkiem Almette bez laktozy z tuńczykiem"), ingredientRepository.findIngredientByIngredientName("Chleb żytni jasny"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z serkiem Almette bez laktozy z tuńczykiem"), ingredientRepository.findIngredientByIngredientName("Serek Almette bez laktozy"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z serkiem Almette bez laktozy z tuńczykiem"), ingredientRepository.findIngredientByIngredientName("Tuńczyk w wodzie"), 85));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z serkiem Almette bez laktozy z tuńczykiem"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory, w zalewie olejowej"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z serkiem Almette bez laktozy z tuńczykiem"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki z serkiem Almette bez laktozy z tuńczykiem"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Śliwki"), 160));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jesienna owsianka z duszonymi śliwkami bez laktozy"), ingredientRepository.findIngredientByIngredientName("Orzechy pistacjowe"), 9));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Makaron pełnoziarnisty"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cebula"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleczko kokosowe (w puszce)"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca, w zalewie"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ser gouda bez laktozy"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron z cukinią z ciecierzycą i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ziemniaki, wczesne"), 210));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ser gouda bez laktozy"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Skrobia ziemniaczana"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mąka pszenna typ 550"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone paprykowe kulki ziemniaczane z serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Papryka słodka (mielona)"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 112));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Musztarda"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Rzodkiewka"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sałata"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe pieczywo z zieloną pastą jajeczną bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kasza gryczana"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kalafior"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Kasza gryczana"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Kalafior"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kasza zapiekana z brokułem i kalafiorem z jogurtem bez laktozy i mięsem"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Mleczko kokosowe (w puszce)"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kiełbasa żywiecka"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek czosnkowa, aromatyzowana"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ser gouda bez laktozy"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z cukinią, kiełbasą żywiecką i serem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Śliwki, suszone"), 53));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Sok cytrynowy"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Skrobia ziemniaczana"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Truskawki"), 35));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Knedle z tofu z suszonymi śliwkami z dodatkiem owoców i jogurtem bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Bataty"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca, w zalewie"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Pomidory z puszki (krojone)"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Szpinak"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bataty z prażoną ciecierzycą, pomidorami i sosem czosnkowym bez laktozy"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny kremowy bez laktozy"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy omlet ryżowy"), ingredientRepository.findIngredientByIngredientName("Ryż biały"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy omlet ryżowy"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy omlet ryżowy"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy omlet ryżowy"), ingredientRepository.findIngredientByIngredientName("Mąka kukurydziana"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy omlet ryżowy"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy omlet ryżowy"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy (obniżona zawartość kwasu erukowego)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z bobem"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z bobem"), ingredientRepository.findIngredientByIngredientName("Bób"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z bobem"), ingredientRepository.findIngredientByIngredientName("Masło ekstra"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z bobem"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z bobem"), ingredientRepository.findIngredientByIngredientName("Nasiona słonecznika"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Makaron ryżowy"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Cebula"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Marchew"), 22));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Passata pomidorowa"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Sól himalajska"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z tofu"), ingredientRepository.findIngredientByIngredientName("Cukier"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapka bezglutenowa z miodem"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapka bezglutenowa z miodem"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 24));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśnik bezglutenowy z dżemem"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 168));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśnik bezglutenowy z dżemem"), ingredientRepository.findIngredientByIngredientName("Woda"), 125));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśnik bezglutenowy z dżemem"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśnik bezglutenowy z dżemem"), ingredientRepository.findIngredientByIngredientName("Mąka kokosowa"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśnik bezglutenowy z dżemem"), ingredientRepository.findIngredientByIngredientName("Skrobia ziemniaczana"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Naleśnik bezglutenowy z dżemem"), ingredientRepository.findIngredientByIngredientName("Dżem truskawkowy, niskosłodzony"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Jabłko"), 150));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Mąka z ciecierzycy"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Mąka kokosowa"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Mleko sojowe"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Cukier"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Cynamon (mielony)"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Jabłko w cieście bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Tortilla kukurydziana"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca (ugotowana)"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Sałata lodowa"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Ogórek"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory, w zalewie olejowej"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa tortilla z warzywami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Szpinak"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Mleko 2% tłuszczu"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Mąka ryżowa"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Placuszki szpinakowe bezglutenowe"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Ser Parmezan"), 16));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z tofu i serem"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tost bezglutenowy z serem i warzywami"), ingredientRepository.findIngredientByIngredientName("Chleb tostowy bezglutenowy"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tost bezglutenowy z serem i warzywami"), ingredientRepository.findIngredientByIngredientName("Ser Gouda, tłusty"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tost bezglutenowy z serem i warzywami"), ingredientRepository.findIngredientByIngredientName("Ogórek"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Marchew"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Pietruszka"), 17));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Soczewica czerwona, suche nasiona"), 24));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Ziemniaki późne"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Seler korzeniowy"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Ogórek kwaszony"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Majonez z tofu"), 8));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Ostra papryka mielona"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Bagietka bezglutenowa"), 83));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Płatki drożdżowe"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Burger vege z bagietką bezglutenową"), ingredientRepository.findIngredientByIngredientName("Sałata"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bezglutenowe kulki ziemniaczane"), ingredientRepository.findIngredientByIngredientName("Ziemniaki, wczesne"), 210));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bezglutenowe kulki ziemniaczane"), ingredientRepository.findIngredientByIngredientName("Jajko kurze (całe)"), 56));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bezglutenowe kulki ziemniaczane"), ingredientRepository.findIngredientByIngredientName("Skrobia ziemniaczana"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bezglutenowe kulki ziemniaczane"), ingredientRepository.findIngredientByIngredientName("Mąka kukurydziana"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bezglutenowe kulki ziemniaczane"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pieczone bezglutenowe kulki ziemniaczane"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Makaron ryżowy"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Papryczka chili, czerwona"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Miso"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Olej kokosowy"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Imbir mielony"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z miso i kurczakiem"), ingredientRepository.findIngredientByIngredientName("Kolendra, suszone liście"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Puree dynia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca, w zalewie"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Tahini"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Sok cytrynowy"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Papryka słodka, wędzona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kanapki bezglutenowe z hummusem dyniowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z leczo pomidorowym"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z leczo pomidorowym"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z leczo pomidorowym"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z leczo pomidorowym"), ingredientRepository.findIngredientByIngredientName("Passata pomidorowa"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z leczo pomidorowym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Ser twarogowy chudy"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny 2%"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Świeża bazylia"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Sałata"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta twarogowa z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kokosowa owsianka bezglutenowa z jagodami"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kokosowa owsianka bezglutenowa z jagodami"), ingredientRepository.findIngredientByIngredientName("Mleko UHT 1,5%"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kokosowa owsianka bezglutenowa z jagodami"), ingredientRepository.findIngredientByIngredientName("Wiórki kokosowe"), 12));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kokosowa owsianka bezglutenowa z jagodami"), ingredientRepository.findIngredientByIngredientName("Czarne jagody"), 130));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Kokosowa owsianka bezglutenowa z jagodami"), ingredientRepository.findIngredientByIngredientName("Morele, suszone"), 16));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa kanapka z kremem czekoladowym"), ingredientRepository.findIngredientByIngredientName("Daktyle suszone"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa kanapka z kremem czekoladowym"), ingredientRepository.findIngredientByIngredientName("Banan"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa kanapka z kremem czekoladowym"), ingredientRepository.findIngredientByIngredientName("Awokado"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa kanapka z kremem czekoladowym"), ingredientRepository.findIngredientByIngredientName("Kakao 16% (proszek)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowa kanapka z kremem czekoladowym"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Szparagi"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Bób"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Świeża bazylia"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z zielonymi warzywami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Łosoś wędzony"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Orzechy nerkowca"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i orzechami"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Cebula"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Krewetki surowe"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Pomidor"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Koncentrat pomidorowy 30%"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Bazylia suszona"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Spaghetti bezglutenowe z cukinią i krewetkami"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Tofu naturalne"), 90));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Skrobia ziemniaczana"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Czerwona cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Sos sojowy"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Woda"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Tofu w sosie sojowym z makaronem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Syrop klonowy"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z twarogiem i truskawkami"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z twarogiem i truskawkami"), ingredientRepository.findIngredientByIngredientName("Ser twarogowy półtłusty"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z twarogiem i truskawkami"), ingredientRepository.findIngredientByIngredientName("Jogurt naturalny 2% tłuszczu"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z twarogiem i truskawkami"), ingredientRepository.findIngredientByIngredientName("Miód pszczeli"), 24));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z twarogiem i truskawkami"), ingredientRepository.findIngredientByIngredientName("Truskawki"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowa owsianka bezglutenowa z owocami"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowa owsianka bezglutenowa z owocami"), ingredientRepository.findIngredientByIngredientName("Odżywka białkowa wegańska Olimp"), 28));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowa owsianka bezglutenowa z owocami"), ingredientRepository.findIngredientByIngredientName("Jogurt kokosowy"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowa owsianka bezglutenowa z owocami"), ingredientRepository.findIngredientByIngredientName("Borówki amerykańskie"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowa owsianka bezglutenowa z owocami"), ingredientRepository.findIngredientByIngredientName("Truskawki"), 140));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Wysokobiałkowa owsianka bezglutenowa z owocami"), ingredientRepository.findIngredientByIngredientName("Orzechy nerkowca"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z mozzarellą i pomidorami"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z mozzarellą i pomidorami"), ingredientRepository.findIngredientByIngredientName("Pomidor koktajlowy"), 200));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z mozzarellą i pomidorami"), ingredientRepository.findIngredientByIngredientName("Świeża bazylia"), 4));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z mozzarellą i pomidorami"), ingredientRepository.findIngredientByIngredientName("Ser mozzarella"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z mozzarellą i pomidorami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z mozzarellą i pomidorami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Mięso z piersi kurczaka, bez skóry"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Szpinak"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Pieczarka"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory"), 14));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Czosnek granulowany"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy ze szpinakiem i pieczarkami"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Papryka czerwona"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Puree dynia"), 75));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Masło orzechowe (bez dodatku soli)"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Mleko 2% tłuszczu"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Ser Parmezan"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Papryka słodka, wędzona"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z sosem dyniowym i papryką"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Szczypiorek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Mascarpone"), 36));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Niebieski ser pleśniowy"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Woda"), 188));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy w sosie z sera pleśniowego"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Brokuły"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Łosoś wędzony"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Cebula"), 25));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Nasiona słonecznika"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Makaron bezglutenowy z łososiem i słonecznikiem"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 60));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Fasola biała, konserwowa"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Cukinia"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Suszone pomidory, w zalewie olejowej"), 30));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Kurkuma mielona"), 3));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z cukinii i fasoli z pieczywem bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 70));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Marchew"), 45));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Mięso mielone z indyka"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Passata pomidorowa"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Oliwa z oliwek"), 10));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Sól himalajska"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Oregano suszone"), 2));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowe spaghetti bolognese z mięsem drobiowym"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Makaron bezglutenowy, kukurydziany"), 80));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca (ugotowana)"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Olej rzepakowy uniwersalny"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Cebula"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Czosnek"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Soda oczyszczona"), 5));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Natka pietruszki"), 6));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Bezglutenowy makaron w sosie pomidorowym z falafelem"), ingredientRepository.findIngredientByIngredientName("Passata pomidorowa"), 100));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z bananem"), ingredientRepository.findIngredientByIngredientName("Płatki owsiane bezglutenowe"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z bananem"), ingredientRepository.findIngredientByIngredientName("Mleko sojowe"), 250));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z bananem"), ingredientRepository.findIngredientByIngredientName("Banan"), 120));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Owsianka bezglutenowa na napoju roślinnym z bananem"), ingredientRepository.findIngredientByIngredientName("Orzechy włoskie"), 15));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Bataty"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Dynia"), 50));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Cebula"), 20));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Ciecierzyca, w zalewie"), 40));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Pieprz czarny mielony"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Sól biała"), 1));
        mealIngredientRepository.save(new MealIngredient(mealRepository.findMealByMealName("Pasta z pieczonego batata na pieczywie bezglutenowym"), ingredientRepository.findIngredientByIngredientName("Chleb bezglutenowy"), 60));

    }

    public Meal getMeal(int id) {
        Meal x = mealRepository.findMealByMealId(id);
        return x;
    }

    public void saveDiet(String bearerToken, List<Meal> listOfMeals) {
        System.out.println("FUNKCJA SAVE DIET");
        System.out.println("wielkość nowej listy: " + listOfMeals.size());
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

            for (Meal meal : listOfMeals) {
                mealKitRepository.save(new mealKit(user, mealRepository.findMealByMealId(meal.getMealId()), 0));
                System.out.println("added: " + meal.getMealId());
            }
    }

    public void saveSevenDiet(String bearerToken, List<Meal> listOfMeals, int c) {
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        for (Meal meal : listOfMeals) {
            mealKitRepository.save(new mealKit(user, mealRepository.findMealByMealId(meal.getMealId()), c));
            System.out.println("added: " + meal.getMealId());
        }
    }

    public void deleteDiet(String bearerToken) {
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        if (!mealKitRepository.existsBy_user(user)) {
            throw new AppException("This username has got no diet!", HttpStatus.BAD_REQUEST);
        }

        mealKitRepository.deleteAllBy_userAndMealGroup(user, 0);
        System.out.println("succesfuly DELETED");
    }

    public void deleteSevenDiet(String bearerToken) {
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        for(int i = 1; i <= 7; i++){
            mealKitRepository.deleteAllBy_userAndMealGroup(user, i);
        }
    }

    public List<Meal> postOneDayDiet(String bearerToken) {
        UserProfileDto userProfile = userService.getUserProfile(bearerToken);
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        if (userProfile == null) {
            throw new AppException("This User has no profile!", HttpStatus.BAD_REQUEST);
        }

        List<Meal> randomMeals = new ArrayList<>();

        if (mealKitRepository.existsBy_user(user)) {
            List<mealKit> meals = new ArrayList<>(mealKitRepository.findAllBy_user(user));
            for (mealKit x : meals) {
                if(x.getMealGroup() == 0) randomMeals.add(x.get_meal());
            }
            if (!randomMeals.isEmpty()) {
                return randomMeals;
            }
        }

        int userCalories = userProfile.getCaloricDemand();
        int dietInfo = userProfile.getDietInfo();
        randomMeals = searchForMeals(userCalories, dietInfo);
        saveDiet(bearerToken, randomMeals);
        return randomMeals;
    }

    public List<Meal> postSevenDayDiet(String bearerToken) {
        UserProfileDto userProfile = userService.getUserProfile(bearerToken);
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        if (userProfile == null) {
            throw new AppException("This User has no profile!", HttpStatus.BAD_REQUEST);
        }

        List<Meal> randomMeals = new ArrayList<>();

        if (mealKitRepository.existsBy_user(user)) {
            List<mealKit> meals = new ArrayList<>(mealKitRepository.findAllBy_user(user));
            for (mealKit x : meals) {
                if(x.getMealGroup() != 0) randomMeals.add(x.get_meal());
            }
            if (!randomMeals.isEmpty()) {
                return randomMeals;
            }
        }

        int userCalories = userProfile.getCaloricDemand();
        int dietInfo = userProfile.getDietInfo();

        for(int i = 1; i <= 7; i++){
            randomMeals = searchForMeals(userCalories, dietInfo);
            saveSevenDiet(bearerToken, randomMeals, i);
        }

        return randomMeals;
    }

    public List<mealKit> getMealKits(String bearerToken) {
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        List<mealKit> mealKits = new ArrayList<>(mealKitRepository.findAllBy_user(user));

        return mealKits;
    }

    public List<Meal> searchForMeals(int userCalories, int dietInfo) {
        List<Meal> randomMeals = new ArrayList<>();

        int sumOfCalories = 0, sumOfCarbs = 0, sumOfFats = 0, sumOfProteins = 0;

        while(!(((userCalories + 60 > sumOfCalories) && (userCalories - 60 < sumOfCalories)) && ((sumOfCarbs * 4 < userCalories * 0.65) && (sumOfCarbs * 4 > userCalories * 0.50)) &&
                ((sumOfFats * 9 < userCalories * 0.30) && (sumOfFats * 9 > userCalories * 0.2)) &&
                ((sumOfProteins * 4 < userCalories * 0.2) && (sumOfProteins * 4 > userCalories * 0.15)))) {

            randomMeals.clear();

            List<Integer> rep = new ArrayList<>();

            int c = 0;
            sumOfCalories = 0;
            sumOfCarbs = 0;
            sumOfFats = 0;
            sumOfProteins = 0;

            while(userCalories - 30 > sumOfCalories){
                do {
                    int b = 0;
                    Meal meal = mealRepository.findRandom();
                    switch(dietInfo){
                        case 111:
                            meal = mealRepository.findRandom();
                            break;
                        case 101:
                            meal = mealRepository.findRandomGlutenFreeByDietInfo(0);
                            break;
                        case 011:
                            meal = mealRepository.findRandomMeatFreeByDietInfo(0);
                            break;
                        case 110:
                            meal = mealRepository.findRandomLactoseFreeByDietInfo(0);
                            break;
                        default:
                            break;
                    }
                    if ("dinner".equals(meal.getCategoryName())) c++;
                    if (c > 1){
                        c = 1;
                        continue;
                    }
                    if(rep.size() > 0){
                        for(int x : rep){
                            if(meal.getMealId() == x) b++;
                        }
                        if(b != 0){
                            continue;
                        }
                    }

                    sumOfCalories += meal.getCalories();
                    sumOfCarbs += meal.getCarbohydrates();
                    sumOfProteins += meal.getProteins();
                    sumOfFats += meal.getFats();

                    rep.add(meal.getMealId());
                    randomMeals.add(meal);

                    break;
                }while(1 == 1);
            }
        }

        double proteinPercentage = ((double) sumOfProteins * 4) / sumOfCalories;
        double carbPercentage = ((double) sumOfCarbs * 4) / sumOfCalories;
        double fatPercentage = ((double) sumOfFats * 9) / sumOfCalories;

        System.out.println("Proteins: " + (proteinPercentage * 100) + "%");
        System.out.println("Carbs: " + (carbPercentage * 100) + "%");
        System.out.println("Fats: " + (fatPercentage * 100) + "%");

        System.out.println("suma kalorii z funkcji: " + sumOfCalories);
        return randomMeals;
    }

    public List<Meal> getDiet(String bearerToken) {
        UserInfo user = userInfoRepository.findUserInfoByUsername(jwtService.extractUsername(bearerToken));

        if (user == null) {
            throw new AppException("No such user!", HttpStatus.BAD_REQUEST);
        }

        List<mealKit> x = mealKitRepository.findAllBy_userAndMealGroup(user, 0);
        if (x == null) {
            throw new AppException("User has no diet set!", HttpStatus.BAD_REQUEST);
        }

        List<Meal> listOfMeals = new ArrayList<>();
        for(mealKit y : x){
            if(y.getMealGroup() == 0) listOfMeals.add(mealRepository.findMealByMealId(y.get_meal().getMealId()));
        }

        return listOfMeals;
    }

    public List<Meal> changeMeal(String bearerToken, List <String> mealNames) {
        UserProfileDto userProfile = userService.getUserProfile(bearerToken);
        if (userProfile == null) {
            throw new AppException("User has no profile set!", HttpStatus.BAD_REQUEST);
        }

        int dietInfo = userProfile.getDietInfo();

        List<Integer> mealsId = new ArrayList<>();

        for(String x : mealNames){
           mealsId.add(mealRepository.findMealByMealName(x).getMealId());
        }

        List<Meal> listOfMeals = getDiet(bearerToken);
        for(int z : mealsId) {
            int d = 0;
            for (Meal y : listOfMeals) {
                if(y.getMealId() == z){
                    d++;
                }
            }
            if (d != 1) throw new AppException("There is no such meal in user diet!", HttpStatus.BAD_REQUEST);
        }

        List<Meal> listOfDeletedMeals = new ArrayList<Meal>();
        List<Meal> listOfOldMeals = new ArrayList<Meal>();

        for(Meal y : listOfMeals){
            int g = 0;
            for(int z : mealsId) {
                if (y.getMealId() == z) {
                    listOfDeletedMeals.add(y);
                    g++;
                }
            }
            if(g == 0) listOfOldMeals.add(y);
        }

        int sumOfCalories = 0;

        for(Meal y : listOfDeletedMeals){
            sumOfCalories += y.getCalories();
        }
        List<Meal> newMeals = new ArrayList<Meal>();
        int c, cc = 0;
        do {
            c = 0;
            List<Meal> meals = new ArrayList<Meal>();
            List<Integer> o = new ArrayList<>();
            meals = searchForMeals(sumOfCalories, dietInfo);

            for(Meal y : meals){
                o.add(y.getMealId());
                for(Meal z : listOfDeletedMeals) {
                    if (y.getMealId() == z.getMealId()){
                        c++;
                    }
                }
                for(int x : mealsId) {
                    if (y.getMealId() == x){
                        c++;
                    }
                }
            }
            for(Meal y : meals) {
                int ccc = 0;
                for(Integer p : o){
                    if(p == y.getMealId()) ccc++;
                }
                if(ccc > 1) c++;
            }
            cc++;
            if (c == 0) {
                for(Meal z : meals) {
                    newMeals.add(z);
                }
            }
            if (cc > 20) {
                throw new AppException("Too many tries getting a diet!", HttpStatus.BAD_REQUEST);
            }
        }while(c != 0);

        for(Meal z : listOfOldMeals) {
            newMeals.add(z);
        }
        int calories = 0;
        for(Meal z : newMeals) {
            System.out.println("   " + z.getMealId());
            calories += z.getCalories();
        }
        if((userProfile.getCaloricDemand() > calories + 70) || (userProfile.getCaloricDemand() < calories - 70)){
            changeMeal(bearerToken, mealNames);
        }
        deleteDiet(bearerToken);
        saveDiet(bearerToken, newMeals);

        return newMeals;
    }
}
