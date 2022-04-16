package com.example.lockermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Size {
    private final Double width;
    private final Double height;

    public boolean canAccomodate(@NonNull final Size packageSize){
        return this.width>=packageSize.getWidth() && this.height>= packageSize.height;
    }
}
