import java.security.MessageDigest;

public class App {
    public static void main(String[] args) throws Exception {

        String[] alfabeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String password = "aa";
        String hashPassword = "961b6dd3ede3cb8ecbaacbd68de040cd78eb2ed5889130cceb4c49268ea4d506";
        String algoritmo = "SHA-256";
        long tiempo = 0;
        String prefijo = "a";

        System.out.println("Hash del password: " + hashPassword);
        PruebaDeco prueba = new PruebaDeco(hashPassword, algoritmo, tiempo, alfabeto, prefijo);

        prueba.generarCombinaciones(prefijo, alfabeto);



        // try {
        //     MessageDigest md = MessageDigest.getInstance("SHA-256");
        //     md.update(bytesCadena);
        //     arreglo = md.digest();
        // } catch (Exception e) {
        //     System.out.println("Error: " + e);
        // }

        // for (int i=0;i<arreglo.length;i++) {
        //     if ((arreglo[i] & 0xff) <= 0xf) {
        //         out+="0";
        //     }
        //     out += Integer.toHexString(arreglo[i] & 0xff);
        // }

        // System.out.println("Hash del password: " + out);
        // System.out.println("Hash que deberia dar: ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb");

        //PruebaDeco prueba = new PruebaDeco(password, out, "SHA-256", 0, alfabeto);

        //prueba.generarCombinaciones("a", 7, alfabeto);
        
    }
}
