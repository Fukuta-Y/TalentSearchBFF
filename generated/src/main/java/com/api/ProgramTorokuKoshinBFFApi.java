/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.MProgram;
import com.model.ProgramTorokuKoshinBFF;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-04T16:43:16.584348+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "programTorokuKoshinBFF", description = "the programTorokuKoshinBFF API")
@RequestMapping("api")
public interface ProgramTorokuKoshinBFFApi {

    /**
     * POST /programTorokuKoshinBFF : 番組情報を登録または更新するBFF
     * 番組情報を登録または更新するBFF
     *
     * @param mprogram 番組情報を登録または更新するBFF (optional)
     * @return 登録または更新した番組マスタ情報 (status code 200)
     */
    @Operation(
        operationId = "postProgramTorokuKoshinBFF",
        summary = "番組情報を登録または更新するBFF",
        tags = { "programInfoBFF" },
        responses = {
            @ApiResponse(responseCode = "200", description = "登録または更新した番組マスタ情報", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ProgramTorokuKoshinBFF.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/programTorokuKoshinBFF",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<ProgramTorokuKoshinBFF> postProgramTorokuKoshinBFF(
        @Parameter(name = "MProgram", description = "番組情報を登録または更新するBFF") @Valid @RequestBody(required = false) MProgram mprogram
    );

}
