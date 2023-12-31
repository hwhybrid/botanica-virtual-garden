package com.portfolio.botanica.dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlantDto {
    private Long plantId;
    private String plantName;
    private String scientificName;
    private String plantDescription;
    private boolean edible;
    private String imageUrl;
}
