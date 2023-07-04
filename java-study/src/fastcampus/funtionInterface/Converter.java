package fastcampus.funtionInterface;

@FunctionalInterface
public interface Converter<F, T> {
    T converrt(F from);
}
