package async;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

    private static List<Enterprise> enterprises = List.of(
            new Enterprise("ent_1", "Google", "ceo_2"),
            new Enterprise("ent_2", "Facebook", "ceo_1")
    );

    private static List<Ceo> ceos = List.of(
            new Ceo("ceo_1", "Mark"),
            new Ceo("ceo_2", "Sundar"),
            new Ceo("ceo_3", "Bill")
    );

    public static CompletableFuture<Option<Ceo>> getCeoById(List<Ceo> ceos, String ceo_id) {
        var ceo = getCeoById(AsyncTest.ceos, ceo_id);
        return (ceo.isDone()) ? ceo : CompletableFuture.supplyAsync(Option::none);
    }

    public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
        var enterprise = getEnterpriseByCeoId(AsyncTest.enterprises, ceo_id);
        return (enterprise.get() != null) ? CompletableFuture.supplyAsync(() -> enterprise) : CompletableFuture.supplyAsync(Option::none);
    }

    public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
        final Option<Ceo> ceoByCeoId = getCeoByCeoId(AsyncTest.ceos, ceo_id);
        final Option<Enterprise> byCeoId = getEnterpriseByCeoId(AsyncTest.enterprises, ceo_id);

        Tuple2<Option<Ceo>, Option<Enterprise>> tuple2 = new Tuple2<>(ceoByCeoId, byCeoId);
        return CompletableFuture.supplyAsync(() -> tuple2);
    }

    private static Option<Ceo> getCeoByCeoId(List<Ceo> ceos, String ceo_id) {
        var ceo = ceos.find(item -> item.id.equals(ceo_id));
        return ceo.isDefined() ? ceo : Option.none();
    }

    private static Option<Enterprise> getEnterpriseByCeoId(List<Enterprise> enterprises, String ceo_id) {
        var enterprise = enterprises.find(item -> item.ceo_id.equals(ceo_id));
        return enterprise.isDefined() ? enterprise : Option.none();
    }
}
