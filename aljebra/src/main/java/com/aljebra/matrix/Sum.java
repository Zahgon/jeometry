/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016-2020, Hamdi Douss
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom
 * the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
 * OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.aljebra.matrix;

import com.aljebra.scalar.Scalar;
import com.aljebra.vector.FixedVector;
import com.aljebra.vector.Vect;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * A Matrix represented as the sum of a set of matrices. The set of matrices are considered
 * to have the same dimensions and this implementation does not make any checks on
 * dimensions.
 * @param <T> scalar types
 * @since 0.1
 */
@EqualsAndHashCode
@ToString(includeFieldNames = false)
public final class Sum<T> implements Matrix<T> {

    /**
     * Sum operands.
     */
    private final Multiset<Matrix<T>> operands;

    /**
     * Constructor.
     * @param operands Sum operands
     */
    public Sum(final Iterable<Matrix<T>> operands) {
        this.operands = HashMultiset.create(operands);
    }

    /**
     * Constructor. Build sum of two matrices.
     * @param first First operand
     * @param second Second operand
     */
    public Sum(final Matrix<T> first, final Matrix<T> second) {
        this(Arrays.asList(first, second));
    }

    @Override
    public Scalar<T>[] coords() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Scalar<T>[] column(final int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Scalar<T>[] line(final int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Vect<T> apply(final Vect<T> input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int columns() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int lines() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Builds a vector given its coordinates.
     * @param coords Vector coordinates
     * @param <T> scalar types
     * @return A {@link FixedVector} instance
     */
    private static <T> FixedVector<T> vector(final Iterable<Scalar<T>> coords) {
        return new FixedVector<T>(coords);
    }
}
