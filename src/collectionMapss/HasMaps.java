package collectionMapss;

import java.util.HashMap;
import java.util.Scanner;

public class HasMaps {
    public static void main(String[] args) {
          /*
        Kullanıcıdan kimlik no(4 hane), tam adını adres tel alın
        kimlik no key  digerleri value
        kimlik no girerek kullanıcın bilgilerine ulasın
         */
        /*saveInfol) method olusturun:
1) Kullanicidan bircok kimlik numarasi(4 haneli), isim, adres ve telefon alin. 2)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin. 3) Ayni kimlik numarası ile bilgi girilmesine engel olun.
getInfo() method olusturunt 1)Kimlik numarasını girerek kullanicinin bilgilerine ulasin. 210lmayan kimlik numarasi girilirse kullaniciya hata mesaji verin. 3)Map bos ise uygun mesaj versin.
removeInfo() method olusturun:
1)Kimlik numarasini girerek data silin.
2)Girilen kimlik numarası yoksa kullaniciya hata mesaji verin. 3)Collection bos ise kullanıcıya bata nēsaji verin.
selectOption() method olusturun: 1) Yukarıdaki 3 methodu programi sonlandırana kadar secme hakki verin*/
        HashMap<String,String> person=new HashMap<>();

        selectOption(person);



        // Kullanıcıdan kimlik no isteyip bilgilerini getirsin. Tekrarli olsun

    }
    public static void saveInfo(HashMap<String,String> person){
        Scanner scan= new Scanner(System.in);
        String id="";
        do {
            System.out.println("Kimlik no girin");
            System.out.println("Bilgi girisini durdurmak icin Q basınız");
            id = scan.next();
            if (id.equalsIgnoreCase("Q")) {
                break;
            }else{
                while(person.containsKey(id)){
                    System.out.println(id+" kayitlarda var gecerli bir id girin");
                    id= scan.next();
                }
            }
            System.out.println("Tam isminizi girin");
            String name=scan.next();
            scan.nextLine();
            System.out.println("Adresinizi giriniz");
            String address= scan.nextLine();
            System.out.println("Tel no griniz");
            String telNo=scan.nextLine();
            String ogrenci="\nİsim : " +name+"\nAdres : "+address+"\nTel : "+telNo;
            person.put(id,ogrenci);

        } while(true);
        System.out.println(person);
    }

    public static void getInfo(HashMap<String,String> person){
        Scanner scan= new Scanner(System.in);
        String id="";
        do {
            System.out.println("Ogrenci bilgisi icin id girin");
            System.out.println("Bilgi girisini durdurmak icin Q basınız");
            id = scan.next();
            if (id.equalsIgnoreCase("Q")){
                break;}
            else if (person.isEmpty()) {
                System.out.println("Herhangi bir kayıt yok");
                break;
            }else if(!person.containsKey(id)) {
                System.out.println("gecerli id girin");

            }else {
                String ogrenciInfo=person.get(id);
                System.out.println(id+"asagidaki bilgileri icerir : \n"+ogrenciInfo);
            }


        }while(true);

    }

    public static void removeInfo(HashMap<String,String> person){
        Scanner scan= new Scanner(System.in);
        String id="";
        do {
            System.out.println("Silmek istediginiz Ogrenci bilgisi icin id girin");
            System.out.println("Silme islemini durdurmak icin Q basınız");
            id = scan.next();
            if (id.equalsIgnoreCase("Q")){
                break;
            }else if(person.isEmpty()){
                break;
            }else if(!person.containsKey(id)){
                System.out.println("gercerli id gir");

            }else {
                String silinenData=person.remove(id);
                System.out.println("Silinen kişi : \n"+ silinenData);
            }

        }while(true);
        System.out.println(person);
    }



    public static void selectOption(HashMap<String,String> person) {
        Scanner scan= new Scanner(System.in);
        String option;
        do{
            System.out.println("Kullanmak istediginiz metodu secin 1-2-3");
            System.out.println("1-Ogrenci ekle2-Ogrenci bilgisi al3-Ogrenci kaydı sil");
            System.out.println("Secim yapmayı sonlandırmak icin Q basin");
            option=scan.next();
            if (option.equalsIgnoreCase("Q")) {
                break;
            }
            switch (option){
                case "1":
                    saveInfo(person);
                    break;
                case "2":
                    getInfo(person);
                    break;
                case "3":
                    removeInfo(person);
                    break;
                default:
                    System.out.println("Yanlis metod sectiniz tekrar deneyin");
            }
        }while(true);

    }
}
}
