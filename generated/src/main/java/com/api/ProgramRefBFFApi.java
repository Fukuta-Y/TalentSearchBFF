/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.ProgramInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-24T18:03:14.333095+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "programRefBFF", description = "the programRefBFF API")
@RequestMapping("${openapi.bFF.base-path:}")
public interface ProgramRefBFFApi {

    /**
     * GET /programRefBFF : 番組ID、番組名によって番組情報を返すBFF
     * 番組ID、番組名によって番組情報を返すBFF
     *
     * @param programId 番組ID (optional)
     * @param programName 番組名 (optional)
     * @return 番組情報を正常取得 (status code 200)
     */
    @Operation(
        operationId = "getProgramRefBFF",
        summary = "番組ID、番組名によって番組情報を返すBFF",
        tags = { "programRefBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "番組情報を正常取得", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProgramInfo.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/programRefBFF",
        produces = { "application/json" }
    )
    ResponseEntity<List<ProgramInfo>> getProgramRefBFF(
        @Size(max = 8) @Parameter(name = "programId", description = "番組ID") @Valid @RequestParam(value = "programId", required = false) String programId,
        @Size(max = 30) @Parameter(name = "programName", description = "番組名") @Valid @RequestParam(value = "programName", required = false) String programName
    );

}
