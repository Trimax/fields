package com.dmitriieliseev.fields.model;

import com.dmitriieliseev.fields.interfaces.Massive;
import lombok.Data;

@Data
public class Body implements Massive {
    private final double mass;
}
