package uk.me.suriar.interview;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class AutoCloser<T> implements AutoCloseable
{
    private T resource;
    private final Consumer<T> cleanup;

    public static <T> AutoCloser<T> newResource(final Supplier<T> supplier, final Consumer<T> cleanup)
    {
	final AutoCloser<T> closer = new AutoCloser<>(cleanup);

	closer.resource = supplier.get();

	if (closer.resource == null)
	    return null;

	return closer;
    }

    public AutoCloser(final Consumer<T> cleanup)
    {
	this.cleanup = cleanup;
    }

    @Override
    public void close() throws Exception
    {
	cleanup.accept(resource);
    }

    public T getResource()
    {
	return resource;
    }
}
