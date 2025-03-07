/*
 * Copyright (c) 2022 Mercedes-Benz Tech Innovation GmbH
 * Copyright (c) 2021,2022 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package org.eclipse.tractusx.edc.hashicorpvault;

import org.eclipse.edc.spi.result.Result;
import org.eclipse.edc.spi.security.Vault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Implements a vault backed by Hashicorp Vault.
 */
class HashicorpVault implements Vault {

    private final HashicorpVaultClient hashicorpVaultClient;

    HashicorpVault(HashicorpVaultClient hashicorpVaultClient) {
        this.hashicorpVaultClient = hashicorpVaultClient;
    }

    @Override
    public @Nullable String resolveSecret(String key) {
        Result<String> result = hashicorpVaultClient.getSecretValue(key);

        return result.succeeded() ? result.getContent() : null;
    }

    @Override
    @NotNull
    public Result<Void> storeSecret(@NotNull String key, @NotNull String value) {
        Result<HashicorpVaultCreateEntryResponsePayload> result =
                hashicorpVaultClient.setSecret(key, value);

        return result.succeeded() ? Result.success() : Result.failure(result.getFailureMessages());
    }

    @Override
    public Result<Void> deleteSecret(@NotNull String key) {
        return hashicorpVaultClient.destroySecret(key);
    }
}
