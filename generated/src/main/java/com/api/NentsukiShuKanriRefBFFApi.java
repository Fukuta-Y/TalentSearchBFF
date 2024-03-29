/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.NentsukiShuKanri;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-11T21:51:26.841831+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "nentsukiShuKanriRefBFF", description = "the nentsukiShuKanriRefBFF API")
@RequestMapping("api")
public interface NentsukiShuKanriRefBFFApi {

    /**
     * GET /nentsukiShuKanriRefBFF : 年月、週によって年月週管理情報を返すBFF
     * 年月、週によって年月週管理情報を返すBFF
     *
     * @param nentsuki 年月 (optional)
     * @param shu 週 (optional)
     * @return 年月週管理情報を正常取得 (status code 200)
     */
    @Operation(
        operationId = "getNentsukiShuKanriRefBFF",
        summary = "年月、週によって年月週管理情報を返すBFF",
        tags = { "nentsukiShuKanriRefBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "年月週管理情報を正常取得", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = NentsukiShuKanri.class))
            })
        }
    )
    @GetMapping("/nentsukiShuKanriRefBFF")
    ResponseEntity<NentsukiShuKanri> getNentsukiShuKanriRefBFF(
        @Min(199001) @Max(210012) @Parameter(name = "nentsuki", description = "年月") @Valid @RequestParam(value = "nentsuki", required = false) Integer nentsuki,
        @Min(1) @Max(5) @Parameter(name = "shu", description = "週") @Valid @RequestParam(value = "shu", required = false) Integer shu
    );

}
