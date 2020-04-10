package com.company;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*String s = "NEZE ETTPMGEXMSRW EVI XCTMGEPPC GSQTMPIH XS FCXIGSHI XLEX GER VYR SR ERC NEZE ZMVXYEP QEGLMRI VIKEVHPIWW SJ XLI YRHIVPCMRK GSQTYXIV EVGLMXIGXYVI";

        char [] string = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < string.length; i++) {
            if (s.charAt(i) == ' '){
                characters.add (s.charAt(i));
                continue;
            }
            char c = (char) (s.charAt(i) - 4);
            if (c < 'A'){
                c += 'Z' - 'A' + 1;
            }
            characters.add(c);
        }

        for (int i = 0; i < characters.size() ; i++) {
            System.out.print(characters.get(i));

        }
        System.out.println();
        System.out.print(characters.get(0));
        System.out.print(characters.get(7));
        System.out.print(characters.get(9));
        System.out.print(characters.get(10));
        System.out.print(characters.get(23));*/

        /*String string = "IMPEDFCJYEIPDTUOSWMYSMIAQYDEONTZTWRNGZFXKYBTLFZFJAUJWOYSECCYUJQJXHKNLEGKDMXLOEFVIFGULESWVMRXRUFZGRTUEUWELUFBLTAJAYSKTZNPEJZZRLKATPQBZHLFFHXLDKWOYTIXSGPCTHFOMOTCKSBOFIJBOBUGJYOIQLBAKKRWVHXSSXRZTQRMKAQSXODALBXZCKYZXATCXHBHKMTWGRRHEPQKNGXLIXHYTTAZSWVCZZUBEOXMUXAHEVBILLJRRVSGRIEUIULKBIPJHGXIKWYGYXZTGEFYDGYVKPRRSFJJRLDDQCUEDFFPEEHOTMWAOEMLXWXVIHIJLRCVIQXGZTXDBNXQGZSYNSIYQBPLNTXDKIJVTJOGKKKAYTVUHMVVTWKOCHETOAZBEPNKQQKCBGLJSOQHRRTQILQKFYHQLSACFNMZTCGLGAZIRINEJRLMHPRDGOTNYIOJDNDFYCIGIACALITODHZHJJXJNZWEUDMFWYPNCDYFOKGNTWPONTQLMMXFDNWZVYARYUEBJIPHGCRMFWTMPTXVERDRGXPMOVLWEYJTXWEAPJXKHKCMSWWIPMQFWSVKIWLUVAKKUUQWAOBDDLRGOWHGQDHSCNUPRJOPRMEGLISBUKQWKTSJCNBVDUQZIHUHPYOAZMKSHKIIWMXSZVLCPCJDRVMSJIDXNLNNVLRMNNKXDYSOKKXMWNRXVVOGKYNTHFAUNKSDZUPKUXPUVKNVQCZJRXSIZQYWHDLOXLVLVENIBQPCMDFCGTGZMQMORQLRAKVMXMNLIGOSYVAIAORAIDUPFHHTRFCPPBYQWQCKJYQMKAETCGHBCEJSSFVXVSIPGFMEOPXAXPYKCWZZGMFWIERBIODKFEKLXOXVQDFQOOORODUSNRCVUWLHOMEETODKDUCKVIQUXYYUFPZALYMKPYNBYTWFHVKGAIEZWSXRUOEONGNEMLDWMNJGEVODASJIJKOJWGLKJKEATXBNODCK";

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println(map);

        for (int i = string.length(); i > 0; i--) {
            for (Character key : map.keySet()) {
                if (map.get(key) == i) {
                    System.out.print(key + " = ");
                    System.out.println(i);
                }
            }
        }*/

        /*char m[][] = new char[50][50];       //первая скобка - количество строк, вторя - столбцов

        m[19][1] = 'A';
        m[49][2] = 'C';
        m[9][9] = 'H';
        m[39][7] = 'I';
        m[1][0] = 'M';
        m[16][42] = 'O';
        m[17][13] = 'R';
        m[19][19] = 'S';
        m[15][30] = 'W';
        m[26][23] = 'Z';

        String str = "RRRRRRRRRBBBBBBBBBBBBBBBBBBBBRRRRRRRRRRUURRRRRRRBBBBBBBBBBBRRURRRRRRRRRRRUUUUUUUUUUUUUUUUUUUUUUUUUURRRRRRRRRRLLLLLLLLLLLBBBBBBBBBBBBBBBBBBBBBLLLLLLLLLLLLLLLUUUULLLLLLUUUUUUUUUUBBBBUUUULLLLLLLLLLLLLLLLUUUUUUUUURRRRR";
        HashMap<Character, Integer> log = new HashMap<>();
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'U':
                    y--;
                    break;
                case 'B':
                    y++;
                    break;
                case 'R':
                    x++;
                    break;
                case 'L':
                    x--;
            }
            if (m[x][y] == '\0') {

            } else {
                char c = m[x][y];
                if (log.containsKey(c)) {
                    log.put(c, log.get(c) + 1);
                    if (log.get(c) == 2) {
                        System.out.print(c);
                    }
                } else {
                    log.put(c, 1);

                }
            }
        }*/

        /*В данном файле зашифровано послание.
            Расшифровав его, вы узнаете ответ к последней задаче.
            Расшифруйте его содержимое, если известно, что каждый его символ был зашифрован по принципу:
            str[i] = (str[i] - (i % 3)) & 0xFF*/

        String str = "";
        try {
            FileReader fr = new FileReader("task5.bin");
            Scanner scan = new Scanner(fr);
            while (scan.hasNextLine()) {
                str += scan.nextLine();
                str += "\n";
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        char[] Str = str.toCharArray();
        for (int i = 0; i < Str.length; i++) {
            Str[i] = (char) (Str[i] + (i % 3));
        }

        for (int i = 0; i < Str.length; i++) {
            System.out.print(Str[i]);
        }
    }
}

