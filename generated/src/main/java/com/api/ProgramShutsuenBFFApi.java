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

import com.model.ProgramShutsuenList;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-19T13:32:33.237081+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "programShutsuenBFF", description = "the programShutsuenBFF API")
@RequestMapping("api")
public interface ProgramShutsuenBFFApi {

    /**
     * GET /programShutsuenBFF : 番組においての対象週の出演者を情報を返すBFF
     * 番組においての対象週の出演者を情報を返すBFF
     *
     * @param programId  (required)
     * @param onAirDay  (required)
     * @param nentsuki  (required)
     * @param shu  (required)
     * @return 番組においての対象週の出演者を情報を正常取得 (status code 200)
     */
    @Operation(
        operationId = "getProgramShutsuenBFF",
        summary = "番組においての対象週の出演者を情報を返すBFF",
        tags = { "programShutsuenBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "番組においての対象週の出演者を情報を正常取得", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProgramShutsuenList.class))
            })
        }
    )
    @GetMapping("/programShutsuenBFF")
    ResponseEntity<ProgramShutsuenList> getProgramShutsuenBFF(
        @NotNull @Size(max = 8) @Parameter(name = "programId", description = "", required = true) @Valid @RequestParam(value = "programId", required = true) String programId,
        @NotNull @Parameter(name = "onAirDay", description = "", required = true) @Valid @RequestParam(value = "onAirDay", required = true) String onAirDay,
        @NotNull @Min(199001) @Max(210012) @Parameter(name = "nentsuki", description = "", required = true) @Valid @RequestParam(value = "nentsuki", required = true) Integer nentsuki,
        @NotNull @Min(1) @Max(5) @Parameter(name = "shu", description = "", required = true) @Valid @RequestParam(value = "shu", required = true) Integer shu
    );

}
