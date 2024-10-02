import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CinemaABC {
    //metodo da pipoca
    public static CompletableFuture<String> getPipoca() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Pipoca pronta";
        });
    }

    //metodo do refrigerante
    public static CompletableFuture<String> getRefrigerante() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Refrigerante pronto";
        });
    }


    public static String lanchePronto() {
        return "Lanche está pronto! Aproveite seu filme!";
    }

    //rodando os códigos
    public static void main(String[] args) {
        int numPipocas = 1; //coloque aqui o número de pipocas
        int numRefrigerantes = 1; //coloque aqui o número de refrigerantes
        int p = 0; //contador
        int r = 0; //contador
    
        try {
            while (p < numPipocas) { 
                CompletableFuture<String> pipocaFuture = getPipoca();
                System.out.println(pipocaFuture.get());
                p++; 
    
           
                if (r < numRefrigerantes) {
                    CompletableFuture<String> refrigeranteFuture = getRefrigerante();
                    System.out.println(refrigeranteFuture.get());
                    r++; 
                }
            }
    
            while (r < numRefrigerantes) {
                CompletableFuture<String> refrigeranteFuture = getRefrigerante();
                System.out.println(refrigeranteFuture.get());
                r++;
            }
    
            System.out.println(lanchePronto());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
