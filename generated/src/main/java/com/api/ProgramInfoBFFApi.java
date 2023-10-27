/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.ProgramInfo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-27T22:11:23.328546+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "programInfoBFF", description = "the programInfoBFF API")
@RequestMapping("${openapi.bFF.base-path:}")
public interface ProgramInfoBFFApi {

    /**
     * GET /programInfoBFF/{programId} : 番組情報を番組IDによって取得するBFF
     * 番組情報を番組IDによって取得するBFF
     *
     * @param programId  (required)
     * @return 番組情報を正常取得 (status code 200)
     */
    @Operation(
        operationId = "getProgramInfoBFF",
        summary = "番組情報を番組IDによって取得するBFF",
        tags = { "programInfoBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "番組情報を正常取得", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProgramInfo.class))
            })
        }
    )
    @GetMapping("/programInfoBFF/programId")
    ResponseEntity<List<ProgramInfo>> getProgramInfoBFF(
        @Size(max = 8) @Parameter(name = "programId", description = "", required = true) @PathVariable("programId") String programId
    );

}
