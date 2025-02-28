package ttt.mardsoul.listdatabase.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ItemDialog(
    onDismissClick: () -> Unit,
    onConfirmClick: () -> Unit,
    dialogTitle: String,
    dialogContent: @Composable () -> Unit,
    icon: ImageVector,
    confirmText: String,
    dismissText: String
) {
    AlertDialog(
        icon = { Icon(icon, contentDescription = null) },
        title = { Text(text = dialogTitle) },
        text = dialogContent,
        onDismissRequest = onDismissClick,
        confirmButton = { TextButton(onClick = onConfirmClick) { Text(confirmText) } },
        dismissButton = { TextButton(onClick = onDismissClick) { Text(dismissText) } }
    )
}