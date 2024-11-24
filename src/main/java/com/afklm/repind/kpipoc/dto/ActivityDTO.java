package com.afklm.repind.kpipoc.dto;

import lombok.*;

/**
 * Activity DTO object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActivityDTO {
    String gin;
    String type;
    String signature;
}
