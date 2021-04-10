package com.hashcorp.delivery.support;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Try<T> {

	static <T> Try<T> of(Supplier<? extends T> supplier) {
		Objects.requireNonNull(supplier, "supplier is null");
		try {
			return new Success<>(supplier.get());
		} catch (Throwable t) {
			return new Failure<>(t);
		}
	}

	default T getOrElse(T other) {
		return isEmpty() ? other : get();
	}

	default <U> Try<U> map(Function<? super T, ? extends U> mapper) {
		Objects.requireNonNull(mapper, "mapper is null");
		return mapTry(mapper::apply);
	}

	default <U> Try<U> mapTry(Function<? super T, ? extends U> mapper) {
		Objects.requireNonNull(mapper, "mapper is null");
		if (isFailure()) {
			return (Failure<U>) this;
		} else {
			try {
				return new Success<>(mapper.apply(get()));
			} catch (Throwable t) {
				return new Failure<>(t);
			}
		}
	}

	T get();

	boolean isEmpty();

	boolean isFailure();

	final class Success<T> implements Try<T>, Serializable {

		private static final long serialVersionUID = 1L;

		private final T value;

		/**
		 * Constructs a Success.
		 *
		 * @param value The value of this Success.
		 */
		private Success(T value) {
			this.value = value;
		}

		public T get() {
			return value;
		}

		public Throwable getCause() {
			throw new UnsupportedOperationException("getCause on Success");
		}

		@Override
		public boolean isEmpty() {
			return false;
		}

		@Override
		public boolean isFailure() {
			return false;
		}

		public boolean isSuccess() {
			return true;
		}
	}

	final class Failure<T> implements Try<T>, Serializable {

		private static final long serialVersionUID = 1L;

		private final Throwable cause;

		private Failure(Throwable cause) {
			Objects.requireNonNull(cause, "cause is null");
			this.cause = cause;
		}

		public Throwable getCause() {
			return cause;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}

		@Override
		public boolean isFailure() {
			return true;
		}

		public boolean isSuccess() {
			return false;
		}

		@Override
		public T get() {
			throw new UnsupportedOperationException();
		}
	}

}
