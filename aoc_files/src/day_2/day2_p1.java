package day_2;

public class day2_p1 {
    public static void main(String[] args) {
        String[] input = common.stringArr(storeInput());
        int sum = 0;
        int y = 0;
        int temp = 0;
        for (int x = 0; x < input.length*4; x++) {
            String tem = "";
            tem = Integer.toString(temp);
            if (presentSym(input,x, numIndex(input[x])[0], numIndex(input[x])[1] )) {
                System.out.println(presentSym(input,x, numIndex(input[x])[0], numIndex(input[x])[1] ));
                if (numIndex(input[x])[1] == 1){
                    temp = input[x].charAt(numIndex(input[x])[0])-48;
                    System.out.println(temp);
                    sum += input[x].charAt(numIndex(input[x])[0])-48;
                }
                else if (numIndex(input[x])[1] == 2){
                    temp = input[x].charAt(numIndex(input[x])[0])-48;
                    System.out.println(temp);
                    sum += (input[x].charAt(numIndex(input[x])[0])-48) + (input[x].charAt(numIndex(input[x])[0]+1)-48);

                }
                else if (numIndex(input[x])[1] == 3){
                    temp = input[x].charAt(numIndex(input[x])[0])-48;
                    System.out.println(temp);
                    sum += (input[x].charAt(numIndex(input[x])[0])-48) + (input[x].charAt(numIndex(input[x])[0]+1)-48) +  (input[x].charAt(numIndex(input[x])[0]+2)-48);
                }
                input[x].replace(tem, ".");
            }
            if (y <= 4 && x == input.length-2) {
                x = 0;
                System.out.println();
                System.out.println();
                System.out.println("new");
                System.out.println();
                System.out.println();
                y ++;
            }
            else if (y > 4) {
                break;
            }
            System.out.println("input index: " + x);

        }
        System.out.println("sum :" + sum);

    }

    private static int[] numIndex (String string) {

        int i = -1;
        int count = 0;
        String [] temp = string.split("");
        for (int x = 0; x<string.length(); x++) {
            if (common.isNumber(string.charAt(x))&& common.isNumber(string.charAt(x+1))&& common.isNumber(string.charAt(x+2))) {
                i = x;
                count = 3;

            }
            else if (common.isNumber(string.charAt(x))&& common.isNumber(string.charAt(x+1))) {
                i = x;
                count = 2;
            }
            else if (common.isNumber(string.charAt(x))) {
                i = x;
                count = 2;
            }
            if (i != -1) {
                return new int []{i, count};
            }
        }
        return new int []{i, count};
    }
    private static boolean presentSym (String[] input, int inputi, int linei, int range) {
        System.out.println(input[inputi]);
        if (inputi == 0) {
            //check for bottom
            if (range < 2 && common.isSymbol(input[inputi + 1].charAt(linei))) {
                return true;
            }
            else if (range < 3 && common.isSymbol(input[inputi + 1].charAt(linei + 1))) {
                return true;
            }
            else if (common.isSymbol(input[inputi + 1].charAt(linei + 2)) && range < 4) {
                return true;
            }
        }
        else if (inputi < 98) {
            //check for bottom
            if (range < 2 && common.isSymbol(input[inputi + 1].charAt(linei))) {
                return true;
            }
            else if (range < 3 && common.isSymbol(input[inputi + 1].charAt(linei + 1))) {
                return true;
            }
            else if (range < 4 && common.isSymbol(input[inputi + 1].charAt(linei + 2))) {
                return true;
            }
            //check for top
            else if (range < 2 && common.isSymbol(input[inputi - 1].charAt(linei))) {
                return true;
            }
            else if (range < 3 && common.isSymbol(input[inputi - 1].charAt(linei + 1))) {
                return true;
            }
            else if (range < 4 && common.isSymbol(input[inputi - 1].charAt(linei + 2))) {
                return true;
            }
        }
        else if (inputi == 99) {System.out.println(input[inputi].charAt(linei + range));
            //check for top
            if (range < 2 && common.isSymbol(input[inputi - 1].charAt(linei))) {
                return true;
            }
            else if (range < 3 && common.isSymbol(input[inputi - 1].charAt(linei + 1))) {
                return true;
            }
            else if (range < 4 && common.isSymbol(input[inputi - 1].charAt(linei + 2))) {
                return true;
            }
            else return false; }
        //check for left hand side
        if (linei != 0 && common.isSymbol(input[inputi].charAt(linei - 1))) {
            return true;
        }
        //check for diagonal (right)
        else if (linei + range < 140 && common.isSymbol(input[inputi + 1].charAt(linei + range))) {
            return true;
        }
        //check for diagonal (left)
        else if (linei != 0 && common.isSymbol(input[inputi + 1].charAt(linei - 1))) {
            return true;
        }
        //check for right hand side
        else if (linei + range < 140 && common.isSymbol(input[inputi].charAt(linei + range))) {
            return true;
        }
        System.out.println("not checked: " + input[inputi].charAt(linei));
        return false;
        //check for left hand side

    }
    private static String storeInput () {
        return "............830..743.......59..955.......663..........................................367...........895....899...............826...220......\n" +
                ".......284.....*..........,..*.....$...+.....*...377..................*.......419.............488...*.......*...................*..-....939..\n" +
                "....%.........976..679.461.7..........350..33.........$.380...$...151.897..........295..#......*....105.....418.............481........&....\n" +
                "...992.....#......=...../........701................508...*..578........................259...331.................795..945........79........\n" +
                ".........868........................*.............................17*..........348................441*852........*.....-...........@.....922\n" +
                "....................*200............311..63................452.......323.#778.*....674....................680......696...372.....*..........\n" +
                ".......266.......209......589.....=......*...365.........7.*...233.............755....*......644...272........697..*....*.....682..225......\n" +
                "..836..........................949....607..........&....*..899...*....679.527.........331..........$....788../.....43....89.................\n" +
                "........367.....328.&......%...............680...69..717.......60.......*.*............................*..........................728...264.\n" +
                "........*.........*..119.253.......................................626....129...274............97...679.......752........*.......*....*.*...\n" +
                "........360......471........../.........573-.702.............866...@...........*......772....../........259....*.........430....136.742.543.\n" +
                ".........................../.852...............*...775...............643....455....../...........832....*.....41..535.......................\n" +
                ".............-..........340.................103....*..........$...51*..................74................438......%...776...+.23*..663......\n" +
                ".15.......806...............990.....................427....924............530.........=..............................*....968.....=....480..\n" +
                "......#..............@914...*..............*........................%......*................................/.....406.................*.....\n" +
                "....201.........79........592............70.894.....247..513+....367..$299.698......199................-.....223....../.........563....783..\n" +
                "......................448........489................*.................................*....440...889...715..........351.....39..............\n" +
                ".138....../766...........*.......................152.........................377....599.......*...*...........................@.............\n" +
                "....%.820.......10*43.670..$87....100*244..@706..........668..319#...........................831.736....@............./..693.....321%.......\n" +
                "......=...930#..................@...................493....*............152......569.................=.914....764.....9.-...................\n" +
                "378$...............&.....854..505.........%........&.....124......12........117.....*591..979..76..133..........+............/..........883.\n" +
                "...............602.141.....*...............770.....................*.........*................../.........874.@....../684....778............\n" +
                "...........................954.....*397.........................394...........614..307*74..457..............+.514.......................327.\n" +
                "........335*25.....-....31..........................................$...719.................*........6..214................878..............\n" +
                "...............86*.269....*...480........................*....140..947....*..&.......................*......972..............*..364*274.....\n" +
                "501-.......805..........285...*..................6....335.167...*........18...332.............741...127......+.............246..............\n" +
                "......616.......752*276.....470.848..599.........*............779..=................539...961..$.........204.......-..201*.....%............\n" +
                ".491.....*..521.........*94.......*.-.....&...163........285/......51..99*......474..*...-.......945.....&......839.......140...201.....$...\n" +
                "....$.795..*........539.........500.......662.............................421....*...459..../.......*407.............../................471.\n" +
                "...........110.......*...............252.............................%..........730......551..509.............824...230....569....48=.......\n" +
                "......150...................................+..70.565=.&320.........983....155................=.....54.......%............*....@......../...\n" +
                "...............972..146...........49.433..137..............................*....%..................@....................436.451..........328\n" +
                "568-...@.552%....-.-................*.................957................93......74...........*........156.566../....#...........285........\n" +
                ".....565..............693....443......................*....394.@58...362...................383.583.............542.38............./..890....\n" +
                "...*.................*........*........&.223...........506.............=..................................300...............477........&....\n" +
                "..612..459..........462....663......125....................720..............355.....253...............904......................*............\n" +
                "........$................................622..............=................*...........*30.........#.$........................284........383\n" +
                "............&.999....&.......................%........240....295*681.846....53.....806......793..646....626./76..737....479.........558.@...\n" +
                ".........892..#.......885.....804..587*....340.........*..............%............*.........*..........*................%............/.....\n" +
                "660..635...........-............./.....213........$....512.....551.............*....910........................@............................\n" +
                "........*..........361..270*.....................328..............*.........853........................*.....985...965............232...948.\n" +
                "..501@......................213...412$.....375..................631..916.......................254...284.........#....*..252........*.......\n" +
                "...................695............................872*876..622..........-.........*..575...851*..................910.395..*....*717.248.....\n" +
                ".....91.........80....*..390...........497....496............*.......@.........297..*................&....873.............946.8.........647.\n" +
                ".......*.424.......108.....=.............*..................686....418.............131........600.96.327...=...561...321............343*....\n" +
                "....731....*..............................938..........256..............909.......................................*.........................\n" +
                ".........811...=....................680...........167...*...601.....................892..#.......142*.......151..108............201.........\n" +
                "................653........879....@.*.........%...*...699..*..............726............695.870.....526.$................*8............234.\n" +
                "....54....311..............=...320..619.......495.375.......926....914.........654..............*........236...$.......444.....@613.........\n" +
                "...*........*......450*............................................*...786.625.......804.850.....674..........305...........................\n" +
                "..593.512....517.......155.....646*239....286......+...........96..264....*......471.*......*.........314*901..............879..............\n" +
                "..........................................=.....419....820......&..................+.......163....148........................*....586.......\n" +
                ".....331.....................637....126.................*..147............650...............................................315....*........\n" +
                ".......%......................$....../.................392....@...943..34...*......752.............................161..30.........970.521..\n" +
                ".........984.412#.......-.569...@................464....................*.275..&.....#.126*506....................*.......=.168-............\n" +
                ".724..................570....*.914.388.........%..$.........274.......263.......130..............102.....2....21+.268....................226\n" +
                "..........776=...6........759.......*..283..309.....682......$..........................................%........................446........\n" +
                "....%284.........-....#...........119....*......622...@....+............/.......929..178...........141/............../650...628.+...........\n" +
                "....................440........88.........335...*.......804............968..976*....+...................$.421..431..................*.......\n" +
                ".....880@.......871.....30......................249...........134....*................*...............95....-...*.....856...353...94.....963\n" +
                "...............*....97..&.......989./.........*.....522+..$.....*.226.436.905......347.396.707...511..........342.....-.....*...........*...\n" +
                "........936*....299.........217.&...478....931.457........62.391............&...............*..../...884*....................370........483.\n" +
                "....965.....992.............*......................................371*771.............37..382...........990...391.......852................\n" +
                ".......*........985.......753.&..........561.204.......................................*......................*...........@..........+935...\n" +
                "......677.....................164.883...............325........951.....847....%......433....*944.50...753..344..............................\n" +
                ".829.......583........429............*34......243...*.........*.............329.%........421...........*..........803..746............675...\n" +
                "...*..................*....512............999.......102......398.................640................401....310.............164...452..*.....\n" +
                "269........9........705....*........782....%.......................615.734....-..............289...........*.....................=....661...\n" +
                "........37.#..............14.......*........../.......586.............*........623.......129........324.....601...%.....@...................\n" +
                "...165................#.........861............463.......*.......361*..............356........175.....*.........906.897..716....118..#......\n" +
                ".....*.............728....417.........+...395#.........443...........829.....390-....................399...............*..........+..813....\n" +
                "....176..253...846......$...........719..........132............897...............334......................20...........51.....%............\n" +
                "..............*....*..278................958........*.......=.................183*.......427.......766.......*..914.282......674............\n" +
                "....&......344...249.....................*.....445.770.....67.....301................295*.........*....715.390...*...../...............424..\n" +
                ".....541......................160.580...........#................=...........*677..............394.......*........327....739...179.360..*...\n" +
                "..........=................%.....*................-954......%.............406......765..................930.....*.........../.....*.....370.\n" +
                "....%.....979.379..........415...............318..........284....440../............-....133.........157......579.550................747.....\n" +
                ".240..........*.....................@...........*642............*.....84.....%.331................2*...................582...=........*.....\n" +
                "......=.....246....167...............704.............763........999.......781...*.....-109............126..801............*.484....632..542.\n" +
                "....%..488.........@..........................$954....*../.....................779..........232................510.....149..................\n" +
                "...27..........984.........*....485.....937........982..234..............225..................*..........122.............................16.\n" +
                "...........473.#..........558..*.............410-...........93............#..655....846....829.....760......=...................=....+......\n" +
                ".....=390..*...................624........#.................+..473..............#......=...........+...577#......$...481.......651.869.806..\n" +
                "747.......543.259.../717............&...346.......948..........$...........472.............230+......=.........206......*...................\n" +
                "................*........+.224/...798.........311...*..896*220...............&.+..................825....../............378...370...........\n" +
                "...............485.641.674.....................*......................618.......389........................565..&674...........*............\n" +
                "..........475.................=.162............461.441...................*..........652......&....508..856...........364....464.............\n" +
                "...............154...452#...693....*................*.......391.........979....344..&.......814..............501.......=....................\n" +
                "...............*................425....25#...........788............879...........*.....29....................&....................850...794\n" +
                "393.............523...507*683..............174@..........-.............=...369....439....-.......*305.891..........952............*.........\n" +
                "..........+...............................................535..911.........................*....1.........441.....-.........88...906........\n" +
                "..........997...17.............779..............960...................209........545......513................*...........98...........+608..\n" +
                ".....................63.968...*.........340.......*...858..339...........%.-767...+...173........47.........906............*210.............\n" +
                ".............&..575..*....@.788.........*.........178.....*.......949.................+...........*.............-.....399.............@.....\n" +
                "..........571....%....984............414...............$.912.....*......302.............594.240..724....341..645.......*.......=..848.642...\n" +
                "....282@...........*......=......189.....138...227*.906.........70......*..................*.............=..........957...657.81../.........\n" +
                "..........*...$.813.179.901.592.....*....................................7....127.............$692...............$..........*.........*.....\n" +
                ".......207..91..............*.....784...872..756.........&..322..............*.........*19.........749.......548..624.694..858...512..598...\n" +
                ".................+.........352...........*.....*.934..126...*.....351..........40...616.......153.....*661............*...........*.........\n" +
                "...823........829...346...........821...826.304...%.......115.......*..........*...............*.............../...622...523.......606......\n" +
                "...*...............*.............*...................186...........813....716@.372....16..300...489..108.....770.......................697..\n" +
                "..........919...782.......912................@.........*.%485............................*..........*...............208.220....853..........\n" +
                "...308......*............*......269.........539.......2.............853.......941.660.532........246.......980..357*....+.....*......./.....\n" +
                "..../......32.164.......15.479.=.............................=...............*....*......................#....*......+......-.855.....415...\n" +
                ".......305..../.....649....*......633...925...634............121............355....578.......14*....422..543.297....429..142................\n" +
                "..960..+..............*.....536......*..@....-.......51..-.........592#..........+..............9..*........................................\n" +
                ".....*......515......434............908..........189......430..................332...722..-.........450..#.........................139......\n" +
                "..259......*.............................39..33.....$..................................*...159..443.....925.............743....414.&...=437.\n" +
                "......58..475...........227%.......217..../...*................../...............&....506..........................63..*.......*............\n" +
                ".......=......-..............993....%.........166........605....293........977+..498......%.....834...455...........*.....%....981.991......\n" +
                "...........636..728...*.......*.......494...............................................205........*.@...........528....226.........#....785\n" +
                "664.9..............$..9...494.272...............725*....775...$....854..........226.243..........832....637*73................165...........\n" +
                "...*...340+.............@...*.......548.............405....*...768..*..............*.......81.........................10.787.$.......918....\n" +
                ".......................145...265....+..........110........45.........90..299.....$........&.....696...475.-452..290....*...*..........@.....\n" +
                "......+....246.108.305...................894....=............121.588......*....69...................................236..97......348........\n" +
                ".......709........*...........-...........-..........411...=...*.......135........................738..383.....634*..........429.@..........\n" +
                "...........%........%217......119.....................@..47.........+.......923..............606...*.......960..............-...............\n" +
                "....835.....744...................546.......215.............512.....950.......%...444......&...$.833......./.........813.......400..%...48..\n" +
                "........362.......898..#.......................*.732........*.............965....&.........584..................521..#...........-.995......\n" +
                "....64.*.........*.....265........781..376...320.#........998...450.......%............................$...............................304..\n" +
                "....-...966...875..981........742*.......*...........*276.........*...............541.....219.279..357..164...551..%717...............%.....\n" +
                "...................*...786.$..........*...163.....915...........960...%...509.135*...........*................-...........%.539.............\n" +
                "....666..699......179..+...612..=734..545...........................88.....&.......392...46..........483=..&.......548.135.....*.413.#620...\n" +
                "...$....*....948..........................530.656....%..484....*..................*......./...741..........444......*.......150...*.........\n" +
                "......................524...928..........=........858....=..562.571........117@.195..896......*......662.......148.388.............320......\n" +
                "...166..48.../....-............#...159.......487.....................260...............#...713.........*.347................................\n" +
                "......*.......657..837.....273.......%........*...155.................*........225..................228.....*370..../.......724.....764.....\n" +
                "......654.679.................@.........-....918...................681..461.............................776......737.................+......\n" +
                "...........*....859......881#............625......$...........888.........+...57...............887.$.......*............................#911\n" +
                "...46*....72...&...................................102.............651........*......*530.......-..667....850..829*.869%........298.........\n" +
                "......925..........892.352*........6.41....................+...160.$.....*.72..878..1.....................................738......*926..32.\n" +
                "...............279.........721......*..............694....799..&......878....*................219....+...482..368$...........*../...........\n" +
                "......604........*....................583*506........-...........740..........347............*....576......*................498..478.974....\n" +
                "..486.-....................626..................320........&....../.................*979.=....863........497........111..............%......\n" +
                "...................................538..78...*.....*......7...455.......223......939......673..........=......559-....*...834............58.\n" +
                ".......644....&.......#..669+.1.......*.....782.....865......*....779..#..............110...../....937..312...........489...................\n" +
                ".......*....571.....69........*.......169...................919....*.....808.................335...*.............................24*896.....\n" +
                ".......233................590.553..............198=..450.........661.......*.....................15...-....................-575.............\n" +
                "...........919*.....................................*.......234.........492..%...........300...........301........./866..........*..........\n" +
                "...............470.....440.874...116....240........299......................27......409.......................................639.136.......";
    }
}
