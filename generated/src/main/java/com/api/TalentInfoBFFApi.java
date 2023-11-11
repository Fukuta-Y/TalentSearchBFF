/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.TalentInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-04T23:34:19.826482+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "talentInfoBFF", description = "the talentInfoBFF API")
@RequestMapping("api")
public interface TalentInfoBFFApi {

    /**
     * GET /talentInfoBFF/{talentId} : タレント情報をタレントIDによって取得するBFF
     * タレント情報をタレントIDによって取得するBFF
     *
     * @param talentId  (required)
     * @return タレント情報を正常取得 (status code 200)
     */
    @Operation(
        operationId = "getTalentInfoBFF",
        summary = "タレント情報をタレントIDによって取得するBFF",
        tags = { "talentInfoBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "タレント情報を正常取得", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TalentInfo.class))
            })
        }
    )
    @GetMapping("/talentInfoBFF/{talentId}")
    ResponseEntity<TalentInfo> getTalentInfoBFF(
        @Size(max = 8) @Parameter(name = "talentId", description = "", required = true) @PathVariable("talentId") String talentId
    );

}
